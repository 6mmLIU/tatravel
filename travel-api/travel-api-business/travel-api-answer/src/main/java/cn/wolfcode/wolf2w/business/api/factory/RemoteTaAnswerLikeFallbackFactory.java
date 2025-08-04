package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteTaAnswerLikeService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerLike;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问答-回答点赞 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Component
public class RemoteTaAnswerLikeFallbackFactory implements FallbackFactory<RemoteTaAnswerLikeService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteTaAnswerLikeFallbackFactory.class);

    @Override
    public RemoteTaAnswerLikeService create(Throwable throwable) {
        log.error("问答-回答点赞服务调用失败:{}", throwable.getMessage());

        return new RemoteTaAnswerLikeService() {
            @Override
            public R<List<TaAnswerLike>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询问答-回答点赞列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<TaAnswerLike> getOne(Long id, String source) {
                return R.fail("查询问答-回答点赞信息失败:" + throwable.getMessage());
            }
        };
    }
}
