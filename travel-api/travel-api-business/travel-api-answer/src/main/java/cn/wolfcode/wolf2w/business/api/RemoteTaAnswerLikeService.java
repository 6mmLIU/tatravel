package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerLike;
import cn.wolfcode.wolf2w.business.api.factory.RemoteTaAnswerLikeFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 问答-回答点赞 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@FeignClient(contextId = "RemoteTaAnswerLikeService", name = ServiceNameConstants.TAANSWER_SERVICE, fallbackFactory = RemoteTaAnswerLikeFallbackFactory.class)
public interface RemoteTaAnswerLikeService {

    @GetMapping("/taAnswerLikes/feign/list")
    R<List<TaAnswerLike>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/taAnswerLikes/feign/{id}")
    R<TaAnswerLike> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
