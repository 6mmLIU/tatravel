package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.domain.StrategyComment;
import cn.sixmm.sixsixsix.business.mapper.StrategyCommentMapper;
import cn.sixmm.sixsixsix.business.query.StrategyCommentQuery;
import cn.sixmm.sixsixsix.business.service.IStrategyCommentService;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.context.SecurityContextHolder;
import cn.sixmm.sixsixsix.member.api.RemoteUserInfoService;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 攻略评论Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class StrategyCommentServiceImpl extends ServiceImpl<StrategyCommentMapper, StrategyComment> implements IStrategyCommentService {
    @Autowired
    private RemoteUserInfoService remoteUserInfoService;

    @Override
    public IPage<StrategyComment> queryPage(StrategyCommentQuery qo) {
        IPage<StrategyComment> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        LambdaQueryWrapper<StrategyComment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StrategyComment::getStrategyId, qo.getStrategyId());
        baseMapper.selectPage(page, queryWrapper);
        for (StrategyComment comment : page.getRecords()) {
            Long userId = comment.getUserId();
            UserInfo userInfo = remoteUserInfoService.getOne(userId, SecurityConstants.INNER).getData();

            comment.setUser(userInfo);
        }
        return page;
    }

    @Override
    public void add(StrategyComment comment) {
        Long userId = SecurityContextHolder.getUserId();
        comment.setUserId(userId);
        comment.setCreateTime(new Date());
        comment.setState(1l);
        comment.setThumbnum(0l);
        baseMapper.insert(comment);
    }
}
