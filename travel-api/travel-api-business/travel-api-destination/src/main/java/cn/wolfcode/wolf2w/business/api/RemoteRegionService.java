package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.business.api.factory.RemoteRegionFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import cn.wolfcode.wolf2w.business.api.domain.Region;

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
