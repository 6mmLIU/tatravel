package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteStrategyContentService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.StrategyContent;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 攻略内容 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteStrategyContentFallbackFactory implements FallbackFactory<RemoteStrategyContentService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteStrategyContentFallbackFactory.class);

    @Override
    public RemoteStrategyContentService create(Throwable throwable) {
        log.error("攻略内容服务调用失败:{}", throwable.getMessage());

        return new RemoteStrategyContentService() {
            @Override
            public R<List<StrategyContent>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询攻略内容列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<StrategyContent> getOne(Long id, String source) {
                return R.fail("查询攻略内容信息失败:" + throwable.getMessage());
            }
        };
    }
}
