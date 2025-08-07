package cn.wolfcode.wolf2w.auth.service;

import cn.wolfcode.wolf2w.common.core.constant.CacheConstants;
import cn.wolfcode.wolf2w.common.core.exception.ServiceException;
import cn.wolfcode.wolf2w.common.redis.service.RedisService;
import cn.wolfcode.wolf2w.common.security.utils.SecurityUtils;

import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 登录密码方法
 *
 * @author ruoyi
 */
@Component
public class PcPasswordService {
    @Autowired
    private RedisService redisService;

    private int maxRetryCount = CacheConstants.passwordMaxRetryCount;

    private Long lockTime = CacheConstants.passwordLockTime;


    /**
     * 登录账户密码错误次数缓存键名
     *
     * @param phone 用户名
     * @return 缓存键key
     */
    private String getCacheKey(String phone) {
        return CacheConstants.PWD_ERR_CNT_KEY +phone;
    }

    public void validate(UserInfo user, String password) {
        String phone = user.getPhone();

        Integer retryCount = redisService.getCacheObject(getCacheKey(phone));

        if (retryCount == null) {
            retryCount = 0;
        }

        if (retryCount >= Integer.valueOf(maxRetryCount).intValue()) {
            String errMsg = String.format("密码输入错误%s次，帐户锁定%s分钟", maxRetryCount, lockTime);
            throw new ServiceException(errMsg);
        }

        if (!matches(user, password)) {
            retryCount = retryCount + 1;
            redisService.setCacheObject(getCacheKey(phone), retryCount, lockTime, TimeUnit.MINUTES);
            throw new ServiceException("用户不存在/密码错误");
        } else {
            clearLoginRecordCache(phone);
        }
    }

    public boolean matches(UserInfo user, String rawPassword) {
        return SecurityUtils.matchesPassword(rawPassword, user.getPassword());
    }


    public void clearLoginRecordCache(String phone) {
        if (redisService.hasKey(getCacheKey(phone))) {
            redisService.deleteObject(getCacheKey(phone));
        }
    }
}
