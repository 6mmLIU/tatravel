package cn.sixmm.sixsixsix.business.api;

import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.NoteContent;
import cn.sixmm.sixsixsix.business.api.factory.RemoteNoteContentFallbackFactory;
import cn.sixmm.sixsixsix.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
* 游记内容 远程服务
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@FeignClient(contextId = "RemoteNoteContentService", name = ServiceNameConstants.NOTE_SERVICE, fallbackFactory = RemoteNoteContentFallbackFactory.class)
public interface RemoteNoteContentService {

    @GetMapping("/noteContents/feign/list")
    R<List<NoteContent>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/noteContents/feign/{id}")
    R<NoteContent> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
