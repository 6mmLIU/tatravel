package cn.sixmm.sixsixsix.business.api;

import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.StrategyCondition;
import cn.sixmm.sixsixsix.business.api.factory.RemoteStrategyConditionFallbackFactory;
import cn.sixmm.sixsixsix.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 攻略条件 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteStrategyConditionService", name = ServiceNameConstants.STRATEGY_SERVICE, fallbackFactory = RemoteStrategyConditionFallbackFactory.class)
public interface RemoteStrategyConditionService {

    @GetMapping("/strategyConditions/feign/list")
    R<List<StrategyCondition>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/strategyConditions/feign/{id}")
    R<StrategyCondition> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
