package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.StrategyConditionQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.StrategyCondition;
import cn.wolfcode.wolf2w.business.service.IStrategyConditionService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 攻略条件Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/conditions")
public class StrategyConditionAdminController extends BaseController
{
    @Autowired
    private IStrategyConditionService strategyConditionService;

    /**
     * 查询攻略条件列表
     */
    @RequiresPermissions("business:condition:list")
    @GetMapping("/list")
    public R<IPage<StrategyCondition>> list(StrategyConditionQuery qo) {
        return R.ok(strategyConditionService.queryPage(qo));
    }


    /**
     * 导出攻略条件列表
     */
    @RequiresPermissions("business:condition:export")
    @Log(title = "攻略条件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StrategyCondition strategyCondition)
    {
        List<StrategyCondition> list = strategyConditionService.list();
        ExcelUtil<StrategyCondition> util = new ExcelUtil<StrategyCondition>(StrategyCondition.class);
        util.exportExcel(response, list, "攻略条件数据");
    }

    /**
     * 获取攻略条件详细信息
     */
    @RequiresPermissions("business:condition:query")
    @GetMapping(value = "/{id}")
    public R<StrategyCondition> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(strategyConditionService.getById(id));
    }

    /**
     * 新增攻略条件
     */
    @RequiresPermissions("business:condition:add")
    @Log(title = "攻略条件", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody StrategyCondition strategyCondition)
    {
        return toAjax(strategyConditionService.save(strategyCondition));
    }

    /**
     * 修改攻略条件
     */
    @RequiresPermissions("business:condition:edit")
    @Log(title = "攻略条件", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody StrategyCondition strategyCondition)
    {
        return toAjax(strategyConditionService.updateById(strategyCondition));
    }

    /**
     * 删除攻略条件
     */
    @RequiresPermissions("business:condition:remove")
    @Log(title = "攻略条件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(strategyConditionService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
