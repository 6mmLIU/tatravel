package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.business.api.factory.RemoteDestinationFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import cn.wolfcode.wolf2w.business.api.domain.Destination;

import java.util.List;

/**
 * 目的地 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteDestinationService",
        name = ServiceNameConstants.DESTINATION_SERVICE,
        fallbackFactory = RemoteDestinationFallbackFactory.class)
public interface RemoteDestinationService {

    @GetMapping("/destinations/feign/list")
    R<List<Destination>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/destinations/feign/{id}")
    R<Destination> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/destinations/isAbroad/{destId}")
    R<Long> isAbroad(@PathVariable("destId") Long destId, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
