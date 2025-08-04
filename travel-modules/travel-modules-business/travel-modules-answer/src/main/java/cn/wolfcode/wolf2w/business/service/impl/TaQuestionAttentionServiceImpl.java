package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaQuestionAttention;
import cn.wolfcode.wolf2w.business.mapper.TaQuestionAttentionMapper;
import cn.wolfcode.wolf2w.business.query.TaQuestionAttentionQuery;
import cn.wolfcode.wolf2w.business.service.ITaQuestionAttentionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 问答-问题关注关系Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@Service
@Transactional
public class TaQuestionAttentionServiceImpl extends ServiceImpl<TaQuestionAttentionMapper,TaQuestionAttention> implements ITaQuestionAttentionService {

    @Override
    public IPage<TaQuestionAttention> queryPage(TaQuestionAttentionQuery qo) {
        IPage<TaQuestionAttention> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }
}
