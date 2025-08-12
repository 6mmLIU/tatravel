package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswerComment;
import cn.wolfcode.wolf2w.business.api.domain.dto.CommentDTO;
import cn.wolfcode.wolf2w.business.mapper.TaAnswerCommentMapper;
import cn.wolfcode.wolf2w.business.query.TaAnswerCommentQuery;
import cn.wolfcode.wolf2w.business.service.ITaAnswerCommentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TaAnswerCommentServiceImpl extends ServiceImpl<TaAnswerCommentMapper,TaAnswerComment> implements ITaAnswerCommentService {

    @Override
    public IPage<TaAnswerComment> queryPage(TaAnswerCommentQuery qo) {
        IPage<TaAnswerComment> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    public Long addComment(CommentDTO commentDTO, Long userId) {
        TaAnswerComment comment = new TaAnswerComment();
        comment.setAnswerId(commentDTO.getAnswerId());
        comment.setUserId(userId);
        comment.setContent(commentDTO.getContent());
        comment.setParentId(commentDTO.getParentId());
        comment.setStatus(0L); // 正常状态
        comment.setCreateTime(new Date());

        this.save(comment);
        return comment.getId();
    }

    @Override
    public List<TaAnswerComment> getCommentsByAnswerId(Long answerId) {
        LambdaQueryWrapper<TaAnswerComment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TaAnswerComment::getAnswerId, answerId)
                .eq(TaAnswerComment::getStatus, 0L)
                .orderByDesc(TaAnswerComment::getCreateTime);
        return this.list(wrapper);
    }

    @Override
    public boolean deleteComment(Long commentId, Long userId) {
        LambdaQueryWrapper<TaAnswerComment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TaAnswerComment::getId, commentId)
                .eq(TaAnswerComment::getUserId, userId);

        TaAnswerComment comment = this.getOne(wrapper);
        if (comment != null) {
            comment.setStatus(1L); // 设置为删除状态
            return this.updateById(comment);
        }
        return false;
    }
}
