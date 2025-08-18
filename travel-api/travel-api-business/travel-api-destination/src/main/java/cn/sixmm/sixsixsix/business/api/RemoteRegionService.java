package cn.sixmm.sixsixsix.business.api;

import cn.sixmm.sixsixsix.business.api.factory.RemoteRegionFallbackFactory;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.constant.ServiceNameConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import cn.sixmm.sixsixsix.business.api.domain.Region;

import java.util.List;

/**
* 区域 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteRegionService", name = ServiceNameConstants.DESTINATION_SERVICE, fallbackFactory = RemoteRegionFallbackFactory.class)
public interface RemoteRegionService {

    @GetMapping("/regions/feign/list")
    R<List<Region>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/regions/feign/{id}")
    R<Region> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
