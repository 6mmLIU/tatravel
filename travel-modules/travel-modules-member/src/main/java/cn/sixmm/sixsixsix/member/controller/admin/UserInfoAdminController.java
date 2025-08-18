package cn.sixmm.sixsixsix.member.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.member.query.UserInfoQuery;
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
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import cn.sixmm.sixsixsix.member.service.IUserInfoService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 前台用户Controller
 * 
 * @author dafei
 * @date 2023-06-18
 */
@RestController
@RequestMapping("/admin/userInfos")
public class UserInfoAdminController extends BaseController
{
    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 查询前台用户列表
     */
    @RequiresPermissions("member:userInfo:list")
    @GetMapping("/list")
    public R<IPage<UserInfo>> list(UserInfoQuery qo) {
        return R.ok(userInfoService.queryPage(qo));
    }


    /**
     * 导出前台用户列表
     */
    @RequiresPermissions("member:userInfo:export")
    @Log(title = "前台用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.list();
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        util.exportExcel(response, list, "前台用户数据");
    }

    /**
     * 获取前台用户详细信息
     */
    @RequiresPermissions("member:userInfo:query")
    @GetMapping(value = "/{id}")
    public R<UserInfo> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(userInfoService.getById(id));
    }

    /**
     * 新增前台用户
     */
    @RequiresPermissions("member:userInfo:add")
    @Log(title = "前台用户", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UserInfo userInfo)
    {
        return toAjax(userInfoService.save(userInfo));
    }

    /**
     * 修改前台用户
     */
    @RequiresPermissions("member:userInfo:edit")
    @Log(title = "前台用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UserInfo userInfo)
    {
        return toAjax(userInfoService.updateById(userInfo));
    }

    /**
     * 删除前台用户
     */
    @RequiresPermissions("member:userInfo:remove")
    @Log(title = "前台用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(userInfoService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
