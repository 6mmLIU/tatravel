package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerComment;
import cn.wolfcode.wolf2w.business.query.TaAnswerCommentQuery;
import cn.wolfcode.wolf2w.business.service.ITaAnswerCommentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 问答-回答评论 Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("taAnswerComments")
public class TaAnswerCommentController {
    @Autowired
    private ITaAnswerCommentService taAnswerCommentService;
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
