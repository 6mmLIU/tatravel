package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteNoteService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.Note;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 旅游日记 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteNoteFallbackFactory implements FallbackFactory<RemoteNoteService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteNoteFallbackFactory.class);

    @Override
    public RemoteNoteService create(Throwable throwable) {
        log.error("旅游日记服务调用失败:{}", throwable.getMessage());

        return new RemoteNoteService() {
            @Override
            public R<List<Note>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询旅游日记列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<Note> getOne(Long id, String source) {
                return R.fail("查询旅游日记信息失败:" + throwable.getMessage());
            }
        };
    }
}
