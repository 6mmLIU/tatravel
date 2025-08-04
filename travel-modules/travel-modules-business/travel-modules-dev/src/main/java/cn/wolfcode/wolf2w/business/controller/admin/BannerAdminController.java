package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.BannerQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.Banner;
import cn.wolfcode.wolf2w.business.service.IBannerService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 文章推荐Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/banners")
public class BannerAdminController extends BaseController
{
    @Autowired
    private IBannerService bannerService;

    /**
     * 查询文章推荐列表
     */
    @RequiresPermissions("business:banner:list")
    @GetMapping("/list")
    public R<IPage<Banner>> list(BannerQuery qo) {
        return R.ok(bannerService.queryPage(qo));
    }


    /**
     * 导出文章推荐列表
     */
    @RequiresPermissions("business:banner:export")
    @Log(title = "文章推荐", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Banner banner)
    {
        List<Banner> list = bannerService.list();
        ExcelUtil<Banner> util = new ExcelUtil<Banner>(Banner.class);
        util.exportExcel(response, list, "文章推荐数据");
    }

    /**
     * 获取文章推荐详细信息
     */
    @RequiresPermissions("business:banner:query")
    @GetMapping(value = "/{id}")
    public R<Banner> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(bannerService.getById(id));
    }

    /**
     * 新增文章推荐
     */
    @RequiresPermissions("business:banner:add")
    @Log(title = "文章推荐", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody Banner banner)
    {
        return toAjax(bannerService.save(banner));
    }

    /**
     * 修改文章推荐
     */
    @RequiresPermissions("business:banner:edit")
    @Log(title = "文章推荐", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody Banner banner)
    {
        return toAjax(bannerService.updateById(banner));
    }

    /**
     * 删除文章推荐
     */
    @RequiresPermissions("business:banner:remove")
    @Log(title = "文章推荐", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(bannerService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
