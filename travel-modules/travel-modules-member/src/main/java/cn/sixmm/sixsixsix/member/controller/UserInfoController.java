package cn.sixmm.sixsixsix.member.controller;

import cn.sixmm.sixsixsix.common.core.constant.UserConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.common.security.service.TokenService;
import cn.sixmm.sixsixsix.common.security.utils.SecurityUtils;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import cn.sixmm.sixsixsix.member.query.UserInfoQuery;
import cn.sixmm.sixsixsix.member.service.IUserInfoService;
import cn.sixmm.sixsixsix.system.api.model.LoginUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台用户 Controller
 * 
 * @author dafei
 * @date 2023-06-18
 */
@RestController
@RequestMapping("userInfos")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private TokenService tokenService;
    /**
     * 前台用户详情
     */
    @GetMapping("/detail/{id}")
    public R<UserInfo> detail(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return R.ok(userInfo);
    }
    /**
     * 前台用户 列表
     */
    @GetMapping("/query")
    public R<IPage<UserInfo>> query(UserInfoQuery qo) {
        IPage<UserInfo> page = userInfoService.queryPage(qo);
        return R.ok(page);
    }
    /**
     * token换取用户信息
     */
    @GetMapping("/getByToken")
    public R<UserInfo> getByToken(Long id) {
        LoginUser userLoginInfo = tokenService.getLoginUser();
        return R.ok(userLoginInfo.getUserInfo());
    }

    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @InnerAuth
    @GetMapping("/feign/list")
    public R<List<UserInfo>> feignList() {
        return R.ok(userInfoService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<UserInfo> feignGet(@PathVariable Long id) {
        return R.ok(userInfoService.getById(id));
    }


    @InnerAuth
    @GetMapping("/feign/queryByUsername")
    public R<UserInfo> queryByUsername(String username) {
        return R.ok(userInfoService.queryByUsername(username));
    }

    @InnerAuth
    @PostMapping("/feign/register")
    public R<Boolean> register(@RequestBody UserInfo userInfo) {
        String username = userInfo.getPhone();
        System.out.println("------------------------------");
        if (userInfoService.checkPhoneUnique(userInfo)) {
            return R.fail("保存用户'" + username + "'失败，注册账号已存在");
        }
        return R.ok(userInfoService.save(userInfo));
    }

}
