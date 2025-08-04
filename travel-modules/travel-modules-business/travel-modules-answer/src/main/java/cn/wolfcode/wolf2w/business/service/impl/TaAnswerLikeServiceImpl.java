package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswerLike;
import cn.wolfcode.wolf2w.business.mapper.TaAnswerLikeMapper;
import cn.wolfcode.wolf2w.business.query.TaAnswerLikeQuery;
import cn.wolfcode.wolf2w.business.service.ITaAnswerLikeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 问答-回答点赞Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@Service
@Transactional
public class TaAnswerLikeServiceImpl extends ServiceImpl<TaAnswerLikeMapper,TaAnswerLike> implements ITaAnswerLikeService {

    @Override
    public IPage<TaAnswerLike> queryPage(TaAnswerLikeQuery qo) {
        IPage<TaAnswerLike> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }
}
