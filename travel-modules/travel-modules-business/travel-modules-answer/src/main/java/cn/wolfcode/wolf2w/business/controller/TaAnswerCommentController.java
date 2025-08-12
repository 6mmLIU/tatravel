package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerComment;
import cn.wolfcode.wolf2w.business.api.domain.dto.CommentDTO;
import cn.wolfcode.wolf2w.business.query.TaAnswerCommentQuery;
import cn.wolfcode.wolf2w.business.service.ITaAnswerCommentService;
import cn.wolfcode.wolf2w.common.security.utils.SecurityUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("taAnswerComments")
public class TaAnswerCommentController {
    @Autowired
    private ITaAnswerCommentService taAnswerCommentService;

    /**
     * 添加评论
     */
    @PostMapping("/add")
    public R<Long> addComment(@RequestBody @Valid CommentDTO commentDTO,
                              HttpServletRequest request,
                              @RequestHeader(value = "user-id", required = false) Long headerUserId) {
        Long userId = SecurityUtils.getUserId();
        if (userId == null) {
            userId = headerUserId;
        }
        if (userId == null) {
            userId = Optional.ofNullable(request.getHeader("user-id")).map(Long::valueOf).orElse(null);
        }
        if (userId == null) {
            return R.fail("未登录或用户ID缺失");
        }

        Long commentId = taAnswerCommentService.addComment(commentDTO, userId);
        return R.ok(commentId);
    }

    /**
     * 获取回答的评论列表
     */
    @GetMapping("/answer/{answerId}")
    public R<List<TaAnswerComment>> getCommentsByAnswerId(@PathVariable Long answerId) {
        List<TaAnswerComment> comments = taAnswerCommentService.getCommentsByAnswerId(answerId);
        return R.ok(comments);
    }

    /**
     * 删除评论
     */
    @DeleteMapping("/{commentId}")
    public R<Boolean> deleteComment(@PathVariable Long commentId,
                                    HttpServletRequest request,
                                    @RequestHeader(value = "user-id", required = false) Long headerUserId) {
        Long userId = SecurityUtils.getUserId();
        if (userId == null) {
            userId = headerUserId;
        }
        if (userId == null) {
            userId = Optional.ofNullable(request.getHeader("user-id")).map(Long::valueOf).orElse(null);
        }
        if (userId == null) {
            return R.fail("未登录或用户ID缺失");
        }

        boolean result = taAnswerCommentService.deleteComment(commentId, userId);
        if (result) {
            return R.ok(true);
        } else {
            return R.fail("删除失败，可能不是你的评论或评论不存在");
        }
    }

    /**
     * 问答-回答评论详情
     */
    @GetMapping("/detail/{id}")
    public R<TaAnswerComment> detail(@PathVariable Long id) {
        TaAnswerComment taAnswerComment = taAnswerCommentService.getById(id);
        return R.ok(taAnswerComment);
    }

    /**
     * 问答-回答评论 列表
     */
    @GetMapping("/query")
    public R<IPage<TaAnswerComment>> query(TaAnswerCommentQuery qo) {
        IPage<TaAnswerComment> page = taAnswerCommentService.queryPage(qo);
        return R.ok(page);
    }

    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<TaAnswerComment>> feignList() {
        return R.ok(taAnswerCommentService.list());
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<TaAnswerComment> feignGet(@PathVariable Long id) {
        return R.ok(taAnswerCommentService.getById(id));
    }
}
