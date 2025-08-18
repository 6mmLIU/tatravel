package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteNoteContentService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.NoteContent;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 游记内容 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteNoteContentFallbackFactory implements FallbackFactory<RemoteNoteContentService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteNoteContentFallbackFactory.class);

    @Override
    public RemoteNoteContentService create(Throwable throwable) {
        log.error("游记内容服务调用失败:{}", throwable.getMessage());

        return new RemoteNoteContentService() {
            @Override
            public R<List<NoteContent>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询游记内容列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<NoteContent> getOne(Long id, String source) {
                return R.fail("查询游记内容信息失败:" + throwable.getMessage());
            }
        };
    }
}
