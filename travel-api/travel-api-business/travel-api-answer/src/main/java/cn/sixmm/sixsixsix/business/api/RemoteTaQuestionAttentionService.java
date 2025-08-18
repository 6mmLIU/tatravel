package cn.sixmm.sixsixsix.business.api;

import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.TaQuestionAttention;
import cn.sixmm.sixsixsix.business.api.factory.RemoteTaQuestionAttentionFallbackFactory;
import cn.sixmm.sixsixsix.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 问答-问题关注关系 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@FeignClient(contextId = "RemoteTaQuestionAttentionService", name = ServiceNameConstants.TAANSWER_SERVICE, fallbackFactory = RemoteTaQuestionAttentionFallbackFactory.class)
public interface RemoteTaQuestionAttentionService {

    @GetMapping("/taQuestionAttentions/feign/list")
    R<List<TaQuestionAttention>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/taQuestionAttentions/feign/{id}")
    R<TaQuestionAttention> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
