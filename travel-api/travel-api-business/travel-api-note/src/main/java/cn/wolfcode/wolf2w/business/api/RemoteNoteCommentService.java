package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.NoteComment;
import cn.wolfcode.wolf2w.business.api.factory.RemoteNoteCommentFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 游记评论 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteNoteCommentService", name = ServiceNameConstants.NOTE_SERVICE, fallbackFactory = RemoteNoteCommentFallbackFactory.class)
public interface RemoteNoteCommentService {

    @GetMapping("/noteComments/feign/list")
    R<List<NoteComment>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/noteComments/feign/{id}")
    R<NoteComment> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
