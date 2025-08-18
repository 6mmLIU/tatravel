package cn.sixmm.sixsixsix.gateway.service;

import java.io.IOException;

import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.core.exception.CaptchaException;
import cn.sixmm.sixsixsix.common.core.web.domain.AjaxResult;
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
