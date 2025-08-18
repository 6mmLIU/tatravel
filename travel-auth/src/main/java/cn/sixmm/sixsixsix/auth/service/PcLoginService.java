package cn.sixmm.sixsixsix.auth.service;


import cn.sixmm.sixsixsix.auth.form.RegisterBody;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.constant.UserConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.core.exception.ServiceException;
import cn.sixmm.sixsixsix.common.core.utils.StringUtils;
import cn.sixmm.sixsixsix.common.core.utils.ip.IpUtils;
import cn.sixmm.sixsixsix.common.redis.service.RedisService;
import cn.sixmm.sixsixsix.common.redis.util.RedisKeys;
import cn.sixmm.sixsixsix.common.security.utils.SecurityUtils;
import cn.sixmm.sixsixsix.member.api.RemoteUserInfoService;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import cn.sixmm.sixsixsix.system.api.model.LoginUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * PC端用户登录与注册
 */
@Component
@Log4j2
public class PcLoginService {


    @Autowired
    private RemoteUserInfoService remoteUserInfoService;

    @Autowired
    private PcPasswordService passwordService;
    @Autowired
    private RedisService redisService;

    /**
     * 登录
     */
    public LoginUser login(String username, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password)) {
            throw new ServiceException("用户/密码必须填写");
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            throw new ServiceException("用户密码不在指定范围");
        }
        // 查询用户信息
        R<UserInfo> userResult = remoteUserInfoService.queryByUsername(username, SecurityConstants.INNER);

        if (R.isError(userResult)) {
            throw new ServiceException(userResult.getMsg());
        }

        if (StringUtils.isNull(userResult.getData())) {
            throw new ServiceException("登录用户：" + username + " 不存在");
        }
        UserInfo user = userResult.getData();
        if (UserConstants.USER_DISABLE.equals(user.getState().toString())) {
            throw new ServiceException("对不起，您的账号：" + username + " 已封禁");
        }
        passwordService.validate(user, password);

        LoginUser loginUser = new LoginUser();
        loginUser.setUserid(user.getId());
        loginUser.setUsername(user.getPhone());
        loginUser.setUserInfo(user);
        loginUser.setState(user.getState());

        return loginUser;
    }

    /**
     * 注册
     */
    public void register(RegisterBody register) {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(register.getUsername(), register.getPassword())) {
            throw new ServiceException("用户/密码/验证码必须填写");
        }
        if (register.getPassword().length() < UserConstants.PASSWORD_MIN_LENGTH
                || register.getPassword().length() > UserConstants.PASSWORD_MAX_LENGTH) {
            throw new ServiceException("密码长度必须在5到20个字符之间");
        }
        if (StringUtils.isBlank(register.getVerifyCode())) {
            throw new ServiceException("手机验证码不能为空");
        }
        String key = RedisKeys.VERIFY_CODE.join(register.getUsername());
        String verify_code_server = redisService.getCacheObject(key);
        if (verify_code_server == null || !register.getVerifyCode().equalsIgnoreCase(verify_code_server)) {
            throw new ServiceException("手机验证码不正确或已过期");
        }
        // 注册用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(register.getUsername());
        userInfo.setNickname(register.getNickname());
        String pwd = SecurityUtils.encryptPassword(register.getPassword());
        userInfo.setPassword(pwd);

        System.out.println(pwd);

        userInfo.setRegisterTime(new Date());
        userInfo.setRegisterIp(IpUtils.getIpAddr());

        R<Boolean> registerResult = remoteUserInfoService.registerUserInfo(userInfo, SecurityConstants.INNER);
        log.info(registerResult);
        if (registerResult.getCode() == 200) {
            // HTTP 码对，但业务失败
            if (!registerResult.getData()) {
                log.error(registerResult);
                throw new ServiceException(registerResult.getMsg());
            }
            // 至此，code==200 且 data==true，注册成功，继续后续逻辑…
        } else {
            // HTTP 码不对，接口调用失败
            throw new ServiceException(registerResult.getMsg());
        }

    }
}
