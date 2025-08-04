package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.Banner;
import cn.wolfcode.wolf2w.business.api.factory.RemoteBannerFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 文章推荐 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteBannerService", name = ServiceNameConstants.ADV_SERVICE, fallbackFactory = RemoteBannerFallbackFactory.class)
public interface RemoteBannerService {

    @GetMapping("/banners/feign/list")
    R<List<Banner>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/banners/feign/{id}")
    R<Banner> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
