package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.NoteComment;
import cn.wolfcode.wolf2w.business.query.NoteCommentQuery;
import cn.wolfcode.wolf2w.business.service.INoteCommentService;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresLogin;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 游记评论 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("noteComments")
public class NoteCommentController {
    @Autowired
    private INoteCommentService noteCommentService;

    /**
     * 游记评论详情
     */
    @GetMapping("/detail/{id}")
    public R<NoteComment> detail(@PathVariable Long id) {
        NoteComment noteComment = noteCommentService.getById(id);
        return R.ok(noteComment);
    }

    /**
     * 游记评论 列表
     */
    @GetMapping("/query")
    public R<IPage<NoteComment>> query(NoteCommentQuery qo) {
        IPage<NoteComment> page = noteCommentService.queryPage(qo);
        return R.ok(page);
    }

    @RequiresLogin
    @PostMapping("/add")
    public R<?> add(@RequestBody NoteComment comment) throws Exception {
        noteCommentService.saveComment(comment);
        return R.ok();
    }

    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<NoteComment>> feignList() {
        return R.ok(noteCommentService.list());
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<NoteComment> feignGet(@PathVariable Long id) {
        return R.ok(noteCommentService.getById(id));
    }
}
