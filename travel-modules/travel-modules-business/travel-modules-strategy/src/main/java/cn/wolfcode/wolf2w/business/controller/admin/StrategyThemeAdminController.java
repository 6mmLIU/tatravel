package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.StrategyThemeQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.StrategyTheme;
import cn.wolfcode.wolf2w.business.service.IStrategyThemeService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 攻略主题Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/strategyThemes")
public class StrategyThemeAdminController extends BaseController {
    @Autowired
    private IStrategyThemeService strategyThemeService;

    @GetMapping("/listAll")
    public R<List<StrategyTheme>> listAll() {
        return R.ok(strategyThemeService.list());
    }

    /**
     * 查询攻略主题列表
     */
    @RequiresPermissions("business:theme:list")
    @GetMapping("/list")
    public R<IPage<StrategyTheme>> list(StrategyThemeQuery qo) {
        return R.ok(strategyThemeService.queryPage(qo));
    }


    /**
     * 导出攻略主题列表
     */
    @RequiresPermissions("business:theme:export")
    @Log(title = "攻略主题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StrategyTheme strategyTheme) {
        List<StrategyTheme> list = strategyThemeService.list();
        ExcelUtil<StrategyTheme> util = new ExcelUtil<StrategyTheme>(StrategyTheme.class);
        util.exportExcel(response, list, "攻略主题数据");
    }

    /**
     * 获取攻略主题详细信息
     */
    @RequiresPermissions("business:theme:query")
    @GetMapping(value = "/{id}")
    public R<StrategyTheme> getInfo(@PathVariable("id") Long id) {
        return R.ok(strategyThemeService.getById(id));
    }

    /**
     * 新增攻略主题
     */
    @RequiresPermissions("business:theme:add")
    @Log(title = "攻略主题", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody StrategyTheme strategyTheme) {
        return toAjax(strategyThemeService.save(strategyTheme));
    }

    /**
     * 修改攻略主题
     */
    @RequiresPermissions("business:theme:edit")
    @Log(title = "攻略主题", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody StrategyTheme strategyTheme) {
        return toAjax(strategyThemeService.updateById(strategyTheme));
    }

    /**
     * 删除攻略主题
     */
    @RequiresPermissions("business:theme:remove")
    @Log(title = "攻略主题", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return toAjax(strategyThemeService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
