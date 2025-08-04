package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswerComment;
import cn.wolfcode.wolf2w.business.mapper.TaAnswerCommentMapper;
import cn.wolfcode.wolf2w.business.query.TaAnswerCommentQuery;
import cn.wolfcode.wolf2w.business.service.ITaAnswerCommentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 问答-回答评论Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@Service
@Transactional
public class TaAnswerCommentServiceImpl extends ServiceImpl<TaAnswerCommentMapper,TaAnswerComment> implements ITaAnswerCommentService {

    @Override
    public IPage<TaAnswerComment> queryPage(TaAnswerCommentQuery qo) {
        IPage<TaAnswerComment> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }
}
