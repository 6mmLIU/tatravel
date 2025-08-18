package cn.sixmm.sixsixsix.system.controller.admin;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.sixmm.sixsixsix.common.core.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.web.page.TableDataInfo;
import cn.sixmm.sixsixsix.common.log.annotation.Log;
import cn.sixmm.sixsixsix.common.log.enums.BusinessType;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.common.security.annotation.RequiresPermissions;
import cn.sixmm.sixsixsix.system.api.domain.SysOperLog;
import cn.sixmm.sixsixsix.system.service.ISysOperLogService;

/**
 * 操作日志记录
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/admin/operlog")
public class SysOperlogAdminController extends BaseController
{
    @Autowired
    private ISysOperLogService operLogService;

    @RequiresPermissions("system:operlog:list")
    @GetMapping("/list")
    public TableDataInfo list(SysOperLog operLog)
    {
        startPage();
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:operlog:export")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperLog operLog)
    {
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        util.exportExcel(response, list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:operlog:remove")
    @DeleteMapping("/{operIds}")
    public R<?> remove(@PathVariable Long[] operIds)
    {
        return toAjax(operLogService.deleteOperLogByIds(operIds));
    }

    @RequiresPermissions("system:operlog:remove")
    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public R<?> clean()
    {
        operLogService.cleanOperLog();
        return success();
    }

    @InnerAuth
    @PostMapping
    public R<?> add(@RequestBody SysOperLog operLog)
    {
        return toAjax(operLogService.insertOperlog(operLog));
    }
}
