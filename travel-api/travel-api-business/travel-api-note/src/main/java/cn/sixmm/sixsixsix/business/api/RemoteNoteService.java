package cn.sixmm.sixsixsix.business.api;

import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.Note;
import cn.sixmm.sixsixsix.business.api.factory.RemoteNoteFallbackFactory;
import cn.sixmm.sixsixsix.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 旅游日记 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteNoteService", name = ServiceNameConstants.NOTE_SERVICE, fallbackFactory = RemoteNoteFallbackFactory.class)
public interface RemoteNoteService {

    @GetMapping("/notes/feign/list")
    R<List<Note>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/notes/feign/{id}")
    R<Note> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
