package cn.sixmm.sixsixsix.gateway.service.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.imageio.ImageIO;

import cn.sixmm.sixsixsix.common.core.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.FastByteArrayOutputStream;
import com.google.code.kaptcha.Producer;
import cn.sixmm.sixsixsix.common.core.constant.CacheConstants;
import cn.sixmm.sixsixsix.common.core.constant.Constants;
import cn.sixmm.sixsixsix.common.core.exception.CaptchaException;
import cn.sixmm.sixsixsix.common.core.utils.StringUtils;
import cn.sixmm.sixsixsix.common.core.utils.sign.Base64;
import cn.sixmm.sixsixsix.common.core.utils.uuid.IdUtils;
import cn.sixmm.sixsixsix.common.core.web.domain.AjaxResult;
import cn.sixmm.sixsixsix.common.redis.service.RedisService;
import cn.sixmm.sixsixsix.gateway.config.properties.CaptchaProperties;
import cn.sixmm.sixsixsix.gateway.service.ValidateCodeService;

/**
 * 验证码实现处理
 *
 * @author ruoyi
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService
{
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisService redisService;

    @Autowired
    private CaptchaProperties captchaProperties;

    /**
     * 生成验证码
     */
    @Override
    public R<ModelMap> createCaptcha() throws IOException, CaptchaException
    {
        ModelMap result = new ModelMap();
        boolean captchaEnabled = captchaProperties.getEnabled();
        result.put("captchaEnabled", captchaEnabled);
        if (!captchaEnabled)
        {
            return  R.ok(result);
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        String captchaType = captchaProperties.getType();
        // 生成验证码
        if ("math".equals(captchaType))
        {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        }
        else if ("char".equals(captchaType))
        {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisService.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return R.fail(e.getMessage());
        }

        result.put("uuid", uuid);
        result.put("img", Base64.encode(os.toByteArray()));
        return R.ok(result);
    }

    /**
     * 校验验证码
     */
    @Override
    public void checkCaptcha(String code, String uuid) throws CaptchaException
    {
        if (StringUtils.isEmpty(code))
        {
            throw new CaptchaException("验证码不能为空");
        }
        if (StringUtils.isEmpty(uuid))
        {
            throw new CaptchaException("验证码已失效");
        }
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisService.getCacheObject(verifyKey);
        redisService.deleteObject(verifyKey);

        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException("验证码错误");
        }
    }
}
