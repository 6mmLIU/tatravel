package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.StrategyQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import cn.wolfcode.wolf2w.business.service.IStrategyService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 攻略Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/strategys")
public class StrategyAdminController extends BaseController
{
    @Autowired
    private IStrategyService strategyService;

    /**
     * 查询攻略列表
     */
    @RequiresPermissions("business:strategy:list")
    @GetMapping("/list")
    public R<IPage<Strategy>> list(StrategyQuery qo) {
        return R.ok(strategyService.queryPage(qo));
    }


    /**
     * 导出攻略列表
     */
    @RequiresPermissions("business:strategy:export")
    @Log(title = "攻略", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Strategy strategy)
    {
        List<Strategy> list = strategyService.list();
        ExcelUtil<Strategy> util = new ExcelUtil<Strategy>(Strategy.class);
        util.exportExcel(response, list, "攻略数据");
    }

    /**
     * 获取攻略详细信息
     */
    @RequiresPermissions("business:strategy:query")
    @GetMapping(value = "/{id}")
    public R<Strategy> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(strategyService.getById(id));
    }

    /**
     * 新增攻略
     */
    @RequiresPermissions("business:strategy:add")
    @Log(title = "攻略", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(Strategy strategy)
    {
        return toAjax(strategyService.saveStrategy(strategy));
    }

    /**
     * 修改攻略
     */
    @RequiresPermissions("business:strategy:edit")
    @Log(title = "攻略", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody Strategy strategy)
    {
        return toAjax(strategyService.updateById(strategy));
    }

    /**
     * 删除攻略
     */
    @RequiresPermissions("business:strategy:remove")
    @Log(title = "攻略", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(strategyService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
