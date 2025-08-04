package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaQuestion;
import cn.wolfcode.wolf2w.business.api.factory.RemoteTaQuestionFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 问答-问题 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@FeignClient(contextId = "RemoteTaQuestionService", name = ServiceNameConstants.TAANSWER_SERVICE, fallbackFactory = RemoteTaQuestionFallbackFactory.class)
public interface RemoteTaQuestionService {

    @GetMapping("/question/feign/list")
    R<List<TaQuestion>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/question/feign/{id}")
    R<TaQuestion> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
