package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteStrategyRankService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.StrategyRank;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 攻略排行 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteStrategyRankFallbackFactory implements FallbackFactory<RemoteStrategyRankService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteStrategyRankFallbackFactory.class);

    @Override
    public RemoteStrategyRankService create(Throwable throwable) {
        log.error("攻略排行服务调用失败:{}", throwable.getMessage());

        return new RemoteStrategyRankService() {
            @Override
            public R<List<StrategyRank>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询攻略排行列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<StrategyRank> getOne(Long id, String source) {
                return R.fail("查询攻略排行信息失败:" + throwable.getMessage());
            }

        };
    }
}
