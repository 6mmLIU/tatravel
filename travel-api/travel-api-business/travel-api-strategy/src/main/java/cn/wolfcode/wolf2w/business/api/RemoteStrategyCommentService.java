package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.StrategyComment;
import cn.wolfcode.wolf2w.business.api.factory.RemoteStrategyCommentFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 攻略评论 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteStrategyCommentService", name = ServiceNameConstants.STRATEGY_SERVICE, fallbackFactory = RemoteStrategyCommentFallbackFactory.class)
public interface RemoteStrategyCommentService {

    @GetMapping("/strategyComments/feign/list")
    R<List<StrategyComment>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/strategyComments/feign/{id}")
    R<StrategyComment> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
