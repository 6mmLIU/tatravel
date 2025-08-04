package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.TaAnswerQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.TaAnswer;
import cn.wolfcode.wolf2w.business.service.ITaAnswerService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 问答-回答Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("/admin/answers")
public class TaAnswerAdminController extends BaseController
{
    @Autowired
    private ITaAnswerService taAnswerService;

    /**
     * 查询问答-回答列表
     */
    @RequiresPermissions("business:answer:list")
    @GetMapping("/list")
    public R<IPage<TaAnswer>> list(TaAnswerQuery qo) {
        return R.ok(taAnswerService.queryPage(qo));
    }


    /**
     * 导出问答-回答列表
     */
    @RequiresPermissions("business:answer:export")
    @Log(title = "问答-回答", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaAnswer taAnswer)
    {
        List<TaAnswer> list = taAnswerService.list();
        ExcelUtil<TaAnswer> util = new ExcelUtil<TaAnswer>(TaAnswer.class);
        util.exportExcel(response, list, "问答-回答数据");
    }

    /**
     * 获取问答-回答详细信息
     */
    @RequiresPermissions("business:answer:query")
    @GetMapping(value = "/{id}")
    public R<TaAnswer> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(taAnswerService.getById(id));
    }

    /**
     * 新增问答-回答
     */
    @RequiresPermissions("business:answer:add")
    @Log(title = "问答-回答", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody TaAnswer taAnswer)
    {
        return toAjax(taAnswerService.save(taAnswer));
    }

    /**
     * 修改问答-回答
     */
    @RequiresPermissions("business:answer:edit")
    @Log(title = "问答-回答", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody TaAnswer taAnswer)
    {
        return toAjax(taAnswerService.updateById(taAnswer));
    }

    /**
     * 删除问答-回答
     */
    @RequiresPermissions("business:answer:remove")
    @Log(title = "问答-回答", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(taAnswerService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
