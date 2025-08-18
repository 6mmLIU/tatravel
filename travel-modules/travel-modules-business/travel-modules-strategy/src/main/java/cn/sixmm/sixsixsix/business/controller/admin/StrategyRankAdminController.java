package cn.sixmm.sixsixsix.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.business.query.StrategyRankQuery;
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
import cn.sixmm.sixsixsix.business.api.domain.StrategyRank;
import cn.sixmm.sixsixsix.business.service.IStrategyRankService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 攻略排行Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/ranks")
public class StrategyRankAdminController extends BaseController
{
    @Autowired
    private IStrategyRankService strategyRankService;

    /**
     * 查询攻略排行列表
     */
    @RequiresPermissions("business:rank:list")
    @GetMapping("/list")
    public R<IPage<StrategyRank>> list(StrategyRankQuery qo) {
        return R.ok(strategyRankService.queryPage(qo));
    }


    /**
     * 导出攻略排行列表
     */
    @RequiresPermissions("business:rank:export")
    @Log(title = "攻略排行", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StrategyRank strategyRank)
    {
        List<StrategyRank> list = strategyRankService.list();
        ExcelUtil<StrategyRank> util = new ExcelUtil<StrategyRank>(StrategyRank.class);
        util.exportExcel(response, list, "攻略排行数据");
    }

    /**
     * 获取攻略排行详细信息
     */
    @RequiresPermissions("business:rank:query")
    @GetMapping(value = "/{id}")
    public R<StrategyRank> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(strategyRankService.getById(id));
    }

    /**
     * 新增攻略排行
     */
    @RequiresPermissions("business:rank:add")
    @Log(title = "攻略排行", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody StrategyRank strategyRank)
    {
        return toAjax(strategyRankService.save(strategyRank));
    }

    /**
     * 修改攻略排行
     */
    @RequiresPermissions("business:rank:edit")
    @Log(title = "攻略排行", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody StrategyRank strategyRank)
    {
        return toAjax(strategyRankService.updateById(strategyRank));
    }

    /**
     * 删除攻略排行
     */
    @RequiresPermissions("business:rank:remove")
    @Log(title = "攻略排行", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(strategyRankService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
