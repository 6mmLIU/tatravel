package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.StrategyCatalogQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog;
import cn.wolfcode.wolf2w.business.service.IStrategyCatalogService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 攻略分类Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/strategyCatalogs")
public class StrategyCatalogAdminController extends BaseController {
    @Autowired
    private IStrategyCatalogService strategyCatalogService;

    @GetMapping("/groupList")
    public R<List<Map<String, Object>>> groupList() {
        List<Map<String, Object>> list = strategyCatalogService.queryGroupList();
        return R.ok(list);
    }


    /**
     * 查询攻略分类列表
     */
    @RequiresPermissions("business:catalog:list")
    @GetMapping("/list")
    public R<IPage<StrategyCatalog>> list(StrategyCatalogQuery qo) {
        return R.ok(strategyCatalogService.queryPage(qo));
    }


    /**
     * 导出攻略分类列表
     */
    @RequiresPermissions("business:catalog:export")
    @Log(title = "攻略分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StrategyCatalog strategyCatalog) {
        List<StrategyCatalog> list = strategyCatalogService.list();
        ExcelUtil<StrategyCatalog> util = new ExcelUtil<StrategyCatalog>(StrategyCatalog.class);
        util.exportExcel(response, list, "攻略分类数据");
    }

    /**
     * 获取攻略分类详细信息
     */
    @RequiresPermissions("business:catalog:query")
    @GetMapping(value = "/{id}")
    public R<StrategyCatalog> getInfo(@PathVariable("id") Long id) {
        return R.ok(strategyCatalogService.getById(id));
    }

    /**
     * 新增攻略分类
     */
    @RequiresPermissions("business:catalog:add")
    @Log(title = "攻略分类", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody StrategyCatalog strategyCatalog) {
        return toAjax(strategyCatalogService.save(strategyCatalog));
    }

    /**
     * 修改攻略分类
     */
    @RequiresPermissions("business:catalog:edit")
    @Log(title = "攻略分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody StrategyCatalog strategyCatalog) {
        return toAjax(strategyCatalogService.updateById(strategyCatalog));
    }

    /**
     * 删除攻略分类
     */
    @RequiresPermissions("business:catalog:remove")
    @Log(title = "攻略分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return toAjax(strategyCatalogService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
