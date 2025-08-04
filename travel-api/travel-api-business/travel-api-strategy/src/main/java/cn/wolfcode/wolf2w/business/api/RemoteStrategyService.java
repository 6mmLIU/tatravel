package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import cn.wolfcode.wolf2w.business.api.factory.RemoteStrategyFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        contextId = "RemoteStrategyService",
        name = ServiceNameConstants.STRATEGY_SERVICE,
        fallbackFactory = RemoteStrategyFallbackFactory.class)
public interface RemoteStrategyService {

    @GetMapping("/strategies/feign/list")
    R<List<Strategy>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/strategies/feign/{id}")
    R<Strategy> getOne(@PathVariable("id") Long id,
                       @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping("/strategies/feign/statisRank")
    R<?> statisRank(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);


    @PostMapping("/strategies/feign/statisCondition")
    R<?> statisCondition(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);


    @PostMapping("/strategies/feign/statisHashPersistence")
    R<?> statisHashPersistence(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
