package cn.sixmm.sixsixsix.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.business.query.StrategyContentQuery;
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
import cn.sixmm.sixsixsix.business.api.domain.StrategyContent;
import cn.sixmm.sixsixsix.business.service.IStrategyContentService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 攻略内容Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/contents")
public class StrategyContentAdminController extends BaseController
{
    @Autowired
    private IStrategyContentService strategyContentService;

    /**
     * 查询攻略内容列表
     */
    @RequiresPermissions("business:content:list")
    @GetMapping("/list")
    public R<IPage<StrategyContent>> list(StrategyContentQuery qo) {
        return R.ok(strategyContentService.queryPage(qo));
    }


    /**
     * 导出攻略内容列表
     */
    @RequiresPermissions("business:content:export")
    @Log(title = "攻略内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StrategyContent strategyContent)
    {
        List<StrategyContent> list = strategyContentService.list();
        ExcelUtil<StrategyContent> util = new ExcelUtil<StrategyContent>(StrategyContent.class);
        util.exportExcel(response, list, "攻略内容数据");
    }

    /**
     * 获取攻略内容详细信息
     */
    @RequiresPermissions("business:content:query")
    @GetMapping(value = "/{id}")
    public R<StrategyContent> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(strategyContentService.getById(id));
    }

    /**
     * 新增攻略内容
     */
    @RequiresPermissions("business:content:add")
    @Log(title = "攻略内容", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody StrategyContent strategyContent)
    {
        return toAjax(strategyContentService.save(strategyContent));
    }

    /**
     * 修改攻略内容
     */
    @RequiresPermissions("business:content:edit")
    @Log(title = "攻略内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody StrategyContent strategyContent)
    {
        return toAjax(strategyContentService.updateById(strategyContent));
    }

    /**
     * 删除攻略内容
     */
    @RequiresPermissions("business:content:remove")
    @Log(title = "攻略内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(strategyContentService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
