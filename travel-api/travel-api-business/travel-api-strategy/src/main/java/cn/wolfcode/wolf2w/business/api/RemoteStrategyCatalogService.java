package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog;
import cn.wolfcode.wolf2w.business.api.factory.RemoteStrategyCatalogFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 攻略分类 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteStrategyCatalogService", name = ServiceNameConstants.STRATEGY_SERVICE, fallbackFactory = RemoteStrategyCatalogFallbackFactory.class)
public interface RemoteStrategyCatalogService {

    @GetMapping("/strategyCatalogs/feign/list")
    R<List<StrategyCatalog>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/strategyCatalogs/feign/{id}")
    R<StrategyCatalog> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
