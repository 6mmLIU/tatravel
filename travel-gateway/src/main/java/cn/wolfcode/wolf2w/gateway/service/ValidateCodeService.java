package cn.wolfcode.wolf2w.gateway.service;

import java.io.IOException;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.core.exception.CaptchaException;
import cn.wolfcode.wolf2w.common.core.web.domain.AjaxResult;
import org.springframework.ui.ModelMap;

/**
 * 验证码处理
 *
 * @author ruoyi
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public R<ModelMap> createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String key, String value) throws CaptchaException;
}
