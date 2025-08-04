package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.NoteContent;
import cn.wolfcode.wolf2w.business.query.NoteContentQuery;
import cn.wolfcode.wolf2w.business.service.INoteContentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 游记内容 Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("noteContents")
public class NoteContentController {
    @Autowired
    private INoteContentService noteContentService;
    /**
     * 游记内容详情
     */
    @GetMapping("/detail/{id}")
    public R<NoteContent> detail(@PathVariable Long id) {
        NoteContent noteContent = noteContentService.getById(id);
        return R.ok(noteContent);
    }
    /**
     * 游记内容 列表
     */
    @GetMapping("/query")
    public R<IPage<NoteContent>> query(NoteContentQuery qo) {
        IPage<NoteContent> page = noteContentService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<NoteContent>> feignList() {
        return R.ok(noteContentService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<NoteContent> feignGet(@PathVariable Long id) {
        return R.ok(noteContentService.getById(id));
    }
}
