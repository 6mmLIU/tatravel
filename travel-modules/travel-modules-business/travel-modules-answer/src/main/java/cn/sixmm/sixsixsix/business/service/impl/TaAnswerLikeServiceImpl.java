package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.domain.TaAnswerLike;
import cn.sixmm.sixsixsix.business.mapper.TaAnswerLikeMapper;
import cn.sixmm.sixsixsix.business.query.TaAnswerLikeQuery;
import cn.sixmm.sixsixsix.business.service.ITaAnswerLikeService;
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
