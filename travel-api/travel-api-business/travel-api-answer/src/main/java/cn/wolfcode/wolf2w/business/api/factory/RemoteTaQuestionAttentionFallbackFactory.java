package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteTaQuestionAttentionService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaQuestionAttention;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问答-问题关注关系 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Component
public class RemoteTaQuestionAttentionFallbackFactory implements FallbackFactory<RemoteTaQuestionAttentionService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteTaQuestionAttentionFallbackFactory.class);

    @Override
    public RemoteTaQuestionAttentionService create(Throwable throwable) {
        log.error("问答-问题关注关系服务调用失败:{}", throwable.getMessage());

        return new RemoteTaQuestionAttentionService() {
            @Override
            public R<List<TaQuestionAttention>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询问答-问题关注关系列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<TaQuestionAttention> getOne(Long id, String source) {
                return R.fail("查询问答-问题关注关系信息失败:" + throwable.getMessage());
            }
        };
    }
}
