package cn.wolfcode.wolf2w.system.controller.admin;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.wolfcode.wolf2w.common.core.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.wolfcode.wolf2w.common.core.constant.CacheConstants;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.web.page.TableDataInfo;
import cn.wolfcode.wolf2w.common.log.annotation.Log;
import cn.wolfcode.wolf2w.common.log.enums.BusinessType;
import cn.wolfcode.wolf2w.common.redis.service.RedisService;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresPermissions;
import cn.wolfcode.wolf2w.system.api.domain.SysLogininfor;
import cn.wolfcode.wolf2w.system.service.ISysLogininforService;

/**
 * 系统访问记录
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/admin/logininfor")
public class SysLogininforAdminController extends BaseController
{
    @Autowired
    private ISysLogininforService logininforService;

    @Autowired
    private RedisService redisService;

    @RequiresPermissions("system:logininfor:list")
    @GetMapping("/list")
    public TableDataInfo list(SysLogininfor logininfor)
    {
        startPage();
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:logininfor:export")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysLogininfor logininfor)
    {
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        ExcelUtil<SysLogininfor> util = new ExcelUtil<SysLogininfor>(SysLogininfor.class);
        util.exportExcel(response, list, "登录日志");
    }

    @RequiresPermissions("system:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public R<?> remove(@PathVariable Long[] infoIds)
    {
        return toAjax(logininforService.deleteLogininforByIds(infoIds));
    }

    @RequiresPermissions("system:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/clean")
    public R<?> clean()
    {
        logininforService.cleanLogininfor();
        return success();
    }

    @RequiresPermissions("system:logininfor:unlock")
    @Log(title = "账户解锁", businessType = BusinessType.OTHER)
    @GetMapping("/unlock/{userName}")
    public R<?> unlock(@PathVariable("userName") String userName)
    {
        redisService.deleteObject(CacheConstants.PWD_ERR_CNT_KEY + userName);
        return success();
    }

    @InnerAuth
    @PostMapping
    public R<?> add(@RequestBody SysLogininfor logininfor)
    {
        return toAjax(logininforService.insertLogininfor(logininfor));
    }
}
