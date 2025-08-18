package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteNoteCommentService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.NoteComment;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 游记评论 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteNoteCommentFallbackFactory implements FallbackFactory<RemoteNoteCommentService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteNoteCommentFallbackFactory.class);

    @Override
    public RemoteNoteCommentService create(Throwable throwable) {
        log.error("游记评论服务调用失败:{}", throwable.getMessage());

        return new RemoteNoteCommentService() {
            @Override
            public R<List<NoteComment>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询游记评论列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<NoteComment> getOne(Long id, String source) {
                return R.fail("查询游记评论信息失败:" + throwable.getMessage());
            }
        };
    }
}
