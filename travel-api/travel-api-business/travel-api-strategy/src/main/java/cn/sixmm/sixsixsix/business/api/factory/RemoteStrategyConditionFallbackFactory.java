package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteStrategyConditionService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.StrategyCondition;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 攻略条件 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteStrategyConditionFallbackFactory implements FallbackFactory<RemoteStrategyConditionService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteStrategyConditionFallbackFactory.class);

    @Override
    public RemoteStrategyConditionService create(Throwable throwable) {
        log.error("攻略条件服务调用失败:{}", throwable.getMessage());

        return new RemoteStrategyConditionService() {
            @Override
            public R<List<StrategyCondition>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询攻略条件列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<StrategyCondition> getOne(Long id, String source) {
                return R.fail("查询攻略条件信息失败:" + throwable.getMessage());
            }
        };
    }
}
