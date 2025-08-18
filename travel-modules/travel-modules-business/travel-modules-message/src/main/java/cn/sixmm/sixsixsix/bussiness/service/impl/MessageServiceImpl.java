package cn.sixmm.sixsixsix.bussiness.service.impl;

import cn.sixmm.sixsixsix.bussiness.service.IMessageService;
import cn.sixmm.sixsixsix.bussiness.util.SmsUtil;
import cn.sixmm.sixsixsix.common.redis.service.RedisService;
import cn.sixmm.sixsixsix.common.redis.util.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private RedisService redisService;

    @Override
    public void sendVerifyCode(String phone) {
        Random random = new Random();
        Integer rand = random.nextInt(90000) + 10000;
        System.err.println("验证码是:" + rand);
//        SmsUtil.sendSmsAli(phone,rand.toString());
        String key = RedisKeys.VERIFY_CODE.join(phone);
//存储验证码到redis
        long time = RedisKeys.VERIFY_CODE.getTime();
        String value = rand.toString();
        redisService.setCacheObject(key, value, time, TimeUnit.SECONDS);
    }
}
