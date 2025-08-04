package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerCollect;
import cn.wolfcode.wolf2w.business.api.factory.RemoteTaAnswerCollectFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 问答-回答收藏关系 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@FeignClient(contextId = "RemoteTaAnswerCollectService", name = ServiceNameConstants.TAANSWER_SERVICE, fallbackFactory = RemoteTaAnswerCollectFallbackFactory.class)
public interface RemoteTaAnswerCollectService {

    @GetMapping("/taAnswerCollects/feign/list")
    R<List<TaAnswerCollect>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/taAnswerCollects/feign/{id}")
    R<TaAnswerCollect> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
