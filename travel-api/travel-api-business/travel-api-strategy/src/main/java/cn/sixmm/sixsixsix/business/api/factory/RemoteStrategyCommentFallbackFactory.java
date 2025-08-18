package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteStrategyCommentService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.StrategyComment;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 攻略评论 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteStrategyCommentFallbackFactory implements FallbackFactory<RemoteStrategyCommentService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteStrategyCommentFallbackFactory.class);

    @Override
    public RemoteStrategyCommentService create(Throwable throwable) {
        log.error("攻略评论服务调用失败:{}", throwable.getMessage());

        return new RemoteStrategyCommentService() {
            @Override
            public R<List<StrategyComment>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询攻略评论列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<StrategyComment> getOne(Long id, String source) {
                return R.fail("查询攻略评论信息失败:" + throwable.getMessage());
            }

        };

    }
}
