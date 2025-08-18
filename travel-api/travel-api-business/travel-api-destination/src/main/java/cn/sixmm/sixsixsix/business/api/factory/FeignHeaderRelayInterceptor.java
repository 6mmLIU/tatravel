package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.common.core.utils.StringUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Component
public class FeignHeaderRelayInterceptor implements RequestInterceptor {
    private static final List<String> HEADERS = Arrays.asList("Authorization", "user-id", "X-Request-Id");

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) return;
        HttpServletRequest req = attrs.getRequest();
        for (String h : HEADERS) {
            String v = req.getHeader(h);
            if (StringUtils.hasText(v)) requestTemplate.header(h, v);
        }
    }
}
