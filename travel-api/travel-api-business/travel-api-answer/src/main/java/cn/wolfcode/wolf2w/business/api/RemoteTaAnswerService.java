package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswer;
import cn.wolfcode.wolf2w.business.api.factory.RemoteTaAnswerFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 问答-回答 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@FeignClient(contextId = "RemoteTaAnswerService", name = ServiceNameConstants.TAANSWER_SERVICE, fallbackFactory = RemoteTaAnswerFallbackFactory.class)
public interface RemoteTaAnswerService {

    @GetMapping("/taAnswers/feign/list")
    R<List<TaAnswer>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/taAnswers/feign/{id}")
    R<TaAnswer> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
