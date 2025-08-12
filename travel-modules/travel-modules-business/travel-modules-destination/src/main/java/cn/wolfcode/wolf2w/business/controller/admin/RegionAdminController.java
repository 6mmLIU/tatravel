package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.RegionQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.Region;
import cn.wolfcode.wolf2w.business.service.IRegionService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 区域Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/regions")
@ApiIgnore
public class RegionAdminController extends BaseController
{
    @Autowired
    private IRegionService regionService;

    /**
     * 查询区域列表
     */
    @RequiresPermissions("business:region:list")
    @GetMapping("/list")
    public R<IPage<Region>> list(RegionQuery qo) {
        return R.ok(regionService.queryPage(qo));
    }


    /**
     * 导出区域列表
     */
    @RequiresPermissions("business:region:export")
    @Log(title = "区域", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Region region)
    {
        List<Region> list = regionService.list();
        ExcelUtil<Region> util = new ExcelUtil<Region>(Region.class);
        util.exportExcel(response, list, "区域数据");
    }

    /**
     * 获取区域详细信息
     */
    @RequiresPermissions("business:region:query")
    @GetMapping(value = "/{id}")
    public R<Region> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(regionService.getById(id));
    }

    /**
     * 新增区域
     */
    @RequiresPermissions("business:region:add")
    @Log(title = "区域", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody Region region)
    {
        return toAjax(regionService.save(region));
    }

    /**
     * 修改区域
     */
    @RequiresPermissions("business:region:edit")
    @Log(title = "区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody Region region)
    {
        return toAjax(regionService.updateById(region));
    }

    /**
     * 删除区域
     */
    @RequiresPermissions("business:region:remove")
    @Log(title = "区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(regionService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
