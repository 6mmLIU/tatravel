package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.business.api.factory.RemoteDestinationFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.Destination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 目的地 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(
        contextId     = "RemoteDestinationService",
        name          = ServiceNameConstants.DESTINATION_SERVICE,
        fallbackFactory = RemoteDestinationFallbackFactory.class
)
public interface RemoteDestinationService {

    /**
     * 分页/筛选获取目的地列表
     */
    @GetMapping("/destinations/feign/list")
    R<List<Destination>> list(
            @RequestParam("type") Integer type,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "size", required = false, defaultValue = "30") Integer size,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 根据 ID 获取单个目的地
     */
    @GetMapping("/destinations/feign/{id}")
    R<Destination> getOne(
            @PathVariable("id") Long id,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 判断目的地是否在境外
     */
    @GetMapping("/destinations/isAbroad/{destId}")
    R<Long> isAbroad(
            @PathVariable("destId") Long destId,
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );

    /**
     * 获取所有目的地（无分页）
     */
    @GetMapping("/destinations/feign/list2")
    R<List<Destination>> list2(
            @RequestHeader(SecurityConstants.FROM_SOURCE) String source
    );
}
