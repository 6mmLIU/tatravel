package cn.sixmm.sixsixsix.auth.controller;

import javax.servlet.http.HttpServletRequest;

import cn.sixmm.sixsixsix.auth.service.PcLoginService;
import cn.sixmm.sixsixsix.common.core.constant.TokenConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cn.sixmm.sixsixsix.auth.form.LoginBody;
import cn.sixmm.sixsixsix.auth.form.RegisterBody;
import cn.sixmm.sixsixsix.auth.service.SysLoginService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.core.utils.JwtUtils;
import cn.sixmm.sixsixsix.common.core.utils.StringUtils;
import cn.sixmm.sixsixsix.common.security.auth.AuthUtil;
import cn.sixmm.sixsixsix.common.security.service.TokenService;
import cn.sixmm.sixsixsix.common.security.utils.SecurityUtils;
import cn.sixmm.sixsixsix.system.api.model.LoginUser;

/**
 * token 控制
 * 
 * @author ruoyi
 */
@RestController
public class TokenController
{
    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    @Autowired
    private PcLoginService pcLoginService;

    @PostMapping("login")
    public R<?> login(@RequestBody LoginBody form)
    {
        // 用户登录
        LoginUser userInfo = null;
        if (form.getType().equals(TokenConstants.ADMIN)) {
            userInfo = sysLoginService.login(form.getUsername(), form.getPassword());
        } else {
            userInfo = pcLoginService.login(form.getUsername(), form.getPassword());
        }
        // 获取登录token
        return R.ok(tokenService.createToken(userInfo));
    }

    @DeleteMapping("logout")
    public R<?> logout(HttpServletRequest request)
    {
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token))
        {
            String username = JwtUtils.getUserName(token);
            // 删除用户缓存记录
            AuthUtil.logoutByToken(token);
            // 记录用户退出日志
            sysLoginService.logout(username);
        }
        return R.ok();
    }

    @PostMapping("refresh")
    public R<?> refresh(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            // 刷新令牌有效期
            tokenService.refreshToken(loginUser);
            return R.ok();
        }
        return R.ok();
    }

    @PostMapping("register")
    public R<?> register(@RequestBody RegisterBody registerBody)
    {
        LoginUser userInfo = null;
        if (registerBody.getType().equals(TokenConstants.ADMIN)) {
            sysLoginService.register(registerBody.getUsername(), registerBody.getPassword());
        } else {
            pcLoginService.register(registerBody);
        }

        return R.ok();
    }
}
