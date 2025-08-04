package cn.wolfcode.wolf2w.member.service.impl;

import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import cn.wolfcode.wolf2w.member.mapper.UserInfoMapper;
import cn.wolfcode.wolf2w.member.query.UserInfoQuery;
import cn.wolfcode.wolf2w.member.service.IUserInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 前台用户Service业务层处理
 * 
 * @author dafei
 * @date 2023-06-18
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements IUserInfoService {

    @Override
    public IPage<UserInfo> queryPage(UserInfoQuery qo) {
        IPage<UserInfo> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .like(StringUtils.hasText(qo.getNickname()), UserInfo::getNickname, qo.getNickname())
                .like(StringUtils.hasText(qo.getPhone()), UserInfo::getPhone, qo.getPhone())
                .eq(qo.getState() != null, UserInfo::getState, qo.getState())
                .page(page);
    }

    @Override
    public UserInfo queryByUsername(String username) {
        return lambdaQuery().eq(UserInfo::getPhone, username).one();
    }

    @Override
    public boolean checkPhoneUnique(UserInfo userInfo) {
        return lambdaQuery().eq(UserInfo::getPhone, userInfo.getPhone()).one() != null;
    }
}
