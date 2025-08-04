package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteTaAnswerCommentService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerComment;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问答-回答评论 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Component
public class RemoteTaAnswerCommentFallbackFactory implements FallbackFactory<RemoteTaAnswerCommentService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteTaAnswerCommentFallbackFactory.class);

    @Override
    public RemoteTaAnswerCommentService create(Throwable throwable) {
        log.error("问答-回答评论服务调用失败:{}", throwable.getMessage());

        return new RemoteTaAnswerCommentService() {
            @Override
            public R<List<TaAnswerComment>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询问答-回答评论列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<TaAnswerComment> getOne(Long id, String source) {
                return R.fail("查询问答-回答评论信息失败:" + throwable.getMessage());
            }
        };
    }
}
