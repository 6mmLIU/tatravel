package cn.sixmm.sixsixsix.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.business.query.NoteCommentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.sixmm.sixsixsix.common.log.annotation.Log;
import cn.sixmm.sixsixsix.common.log.enums.BusinessType;
import cn.sixmm.sixsixsix.common.security.annotation.RequiresPermissions;
import cn.sixmm.sixsixsix.business.api.domain.NoteComment;
import cn.sixmm.sixsixsix.business.service.INoteCommentService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 游记评论Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/comments")
public class NoteCommentAdminController extends BaseController
{
    @Autowired
    private INoteCommentService noteCommentService;

    /**
     * 查询游记评论列表
     */
    @RequiresPermissions("business:comment:list")
    @GetMapping("/list")
    public R<IPage<NoteComment>> list(NoteCommentQuery qo) {
        return R.ok(noteCommentService.queryPage(qo));
    }


    /**
     * 导出游记评论列表
     */
    @RequiresPermissions("business:comment:export")
    @Log(title = "游记评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteComment noteComment)
    {
        List<NoteComment> list = noteCommentService.list();
        ExcelUtil<NoteComment> util = new ExcelUtil<NoteComment>(NoteComment.class);
        util.exportExcel(response, list, "游记评论数据");
    }

    /**
     * 获取游记评论详细信息
     */
    @RequiresPermissions("business:comment:query")
    @GetMapping(value = "/{id}")
    public R<NoteComment> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(noteCommentService.getById(id));
    }

    /**
     * 新增游记评论
     */
    @RequiresPermissions("business:comment:add")
    @Log(title = "游记评论", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody NoteComment noteComment)
    {
        return toAjax(noteCommentService.save(noteComment));
    }

    /**
     * 修改游记评论
     */
    @RequiresPermissions("business:comment:edit")
    @Log(title = "游记评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody NoteComment noteComment)
    {
        return toAjax(noteCommentService.updateById(noteComment));
    }

    /**
     * 删除游记评论
     */
    @RequiresPermissions("business:comment:remove")
    @Log(title = "游记评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(noteCommentService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
