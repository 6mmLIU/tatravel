package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.TaAnswerComment;
import cn.sixmm.sixsixsix.business.api.domain.dto.CommentDTO;
import cn.sixmm.sixsixsix.business.query.TaAnswerCommentQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ITaAnswerCommentService extends IService<TaAnswerComment>{
    IPage<TaAnswerComment> queryPage(TaAnswerCommentQuery qo);

    // 新增评论
    Long addComment(CommentDTO commentDTO, Long userId);

    // 获取回答的评论列表
    List<TaAnswerComment> getCommentsByAnswerId(Long answerId);

    // 删除评论
    boolean deleteComment(Long commentId, Long userId);
}
