package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.StrategyRank;
import cn.wolfcode.wolf2w.business.api.factory.RemoteStrategyRankFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 攻略排行 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteStrategyRankService", name = ServiceNameConstants.STRATEGY_SERVICE, fallbackFactory = RemoteStrategyRankFallbackFactory.class)
public interface RemoteStrategyRankService {

    @GetMapping("/strategyRanks/feign/list")
    R<List<StrategyRank>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/strategyRanks/feign/{id}")
    R<StrategyRank> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
