package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerComment;
import cn.wolfcode.wolf2w.business.api.factory.RemoteTaAnswerCommentFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 问答-回答评论 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@FeignClient(contextId = "RemoteTaAnswerCommentService", name = ServiceNameConstants.TAANSWER_SERVICE, fallbackFactory = RemoteTaAnswerCommentFallbackFactory.class)
public interface RemoteTaAnswerCommentService {

    @GetMapping("/taAnswerComments/feign/list")
    R<List<TaAnswerComment>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/taAnswerComments/feign/{id}")
    R<TaAnswerComment> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
