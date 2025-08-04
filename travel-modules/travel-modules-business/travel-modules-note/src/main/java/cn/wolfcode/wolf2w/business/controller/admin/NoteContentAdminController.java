package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.NoteContentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.wolfcode.wolf2w.common.log.annotation.Log;
import cn.wolfcode.wolf2w.common.log.enums.BusinessType;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresPermissions;
import cn.wolfcode.wolf2w.business.api.domain.NoteContent;
import cn.wolfcode.wolf2w.business.service.INoteContentService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 游记内容Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/contents")
public class NoteContentAdminController extends BaseController
{
    @Autowired
    private INoteContentService noteContentService;

    /**
     * 查询游记内容列表
     */
    @RequiresPermissions("business:content:list")
    @GetMapping("/list")
    public R<IPage<NoteContent>> list(NoteContentQuery qo) {
        return R.ok(noteContentService.queryPage(qo));
    }


    /**
     * 导出游记内容列表
     */
    @RequiresPermissions("business:content:export")
    @Log(title = "游记内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteContent noteContent)
    {
        List<NoteContent> list = noteContentService.list();
        ExcelUtil<NoteContent> util = new ExcelUtil<NoteContent>(NoteContent.class);
        util.exportExcel(response, list, "游记内容数据");
    }

    /**
     * 获取游记内容详细信息
     */
    @RequiresPermissions("business:content:query")
    @GetMapping(value = "/{id}")
    public R<NoteContent> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(noteContentService.getById(id));
    }

    /**
     * 新增游记内容
     */
    @RequiresPermissions("business:content:add")
    @Log(title = "游记内容", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody NoteContent noteContent)
    {
        return toAjax(noteContentService.save(noteContent));
    }

    /**
     * 修改游记内容
     */
    @RequiresPermissions("business:content:edit")
    @Log(title = "游记内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody NoteContent noteContent)
    {
        return toAjax(noteContentService.updateById(noteContent));
    }

    /**
     * 删除游记内容
     */
    @RequiresPermissions("business:content:remove")
    @Log(title = "游记内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(noteContentService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
