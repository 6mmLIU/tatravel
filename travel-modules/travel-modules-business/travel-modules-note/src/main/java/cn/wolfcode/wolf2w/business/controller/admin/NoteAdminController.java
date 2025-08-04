package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.NoteQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.Note;
import cn.wolfcode.wolf2w.business.service.INoteService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 旅游日记Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/notes")
public class NoteAdminController extends BaseController
{
    @Autowired
    private INoteService noteService;

    /**
     * 查询旅游日记列表
     */
    @RequiresPermissions("business:note:list")
    @GetMapping("/list")
    public R<IPage<Note>> list(NoteQuery qo) {
        return R.ok(noteService.queryPage(qo));
    }


    /**
     * 导出旅游日记列表
     */
    @RequiresPermissions("business:note:export")
    @Log(title = "旅游日记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Note note)
    {
        List<Note> list = noteService.list();
        ExcelUtil<Note> util = new ExcelUtil<Note>(Note.class);
        util.exportExcel(response, list, "旅游日记数据");
    }

    /**
     * 获取旅游日记详细信息
     */
    @RequiresPermissions("business:note:query")
    @GetMapping(value = "/{id}")
    public R<Note> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(noteService.getById(id));
    }

    /**
     * 新增旅游日记
     */
    @RequiresPermissions("business:note:add")
    @Log(title = "旅游日记", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody Note note)
    {
        return toAjax(noteService.save(note));
    }

    /**
     * 修改旅游日记
     */
    @RequiresPermissions("business:note:edit")
    @Log(title = "旅游日记", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody Note note)
    {
        return toAjax(noteService.updateById(note));
    }

    /**
     * 删除旅游日记
     */
    @RequiresPermissions("business:note:remove")
    @Log(title = "旅游日记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(noteService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
