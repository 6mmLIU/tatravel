package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.DestinationQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.Destination;
import cn.wolfcode.wolf2w.business.service.IDestinationService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 目的地Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/destinations")
public class DestinationAdminController extends BaseController {
    @Autowired
    private IDestinationService destinationService;

    @GetMapping("/toasts")
    public R<List<Destination>> toasts(Long destId) {
        List<Destination> list= destinationService.queryToasts(destId);
        return R.ok(list);
    }

    /**
     * 查询目的地列表
     */
    @RequiresPermissions("business:destination:list")
    @GetMapping("/list")
    public R<IPage<Destination>> list(DestinationQuery qo) {
        return R.ok(destinationService.queryPage(qo));
    }


    /**
     * 导出目的地列表
     */
    @RequiresPermissions("business:destination:export")
    @Log(title = "目的地", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Destination destination) {
        List<Destination> list = destinationService.list();
        ExcelUtil<Destination> util = new ExcelUtil<Destination>(Destination.class);
        util.exportExcel(response, list, "目的地数据");
    }

    /**
     * 获取目的地详细信息
     */
    @RequiresPermissions("business:destination:query")
    @GetMapping(value = "/{id}")
    public R<Destination> getInfo(@PathVariable("id") Long id) {
        return R.ok(destinationService.getById(id));
    }

    /**
     * 新增目的地
     */
    @RequiresPermissions("business:destination:add")
    @Log(title = "目的地", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody Destination destination) {
        return toAjax(destinationService.save(destination));
    }

    /**
     * 修改目的地
     */
    @RequiresPermissions("business:destination:edit")
    @Log(title = "目的地", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody Destination destination) {
        return toAjax(destinationService.updateById(destination));
    }

    /**
     * 删除目的地
     */
    @RequiresPermissions("business:destination:remove")
    @Log(title = "目的地", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return toAjax(destinationService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
