package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteStrategyService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 攻略 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Slf4j
@Component
public class RemoteStrategyFallbackFactory implements FallbackFactory<RemoteStrategyService> {
    @Override
    public RemoteStrategyService create(Throwable throwable) {
        log.error("攻略服务调用失败", throwable);
        return new RemoteStrategyService() {
            @Override
            public R<List<Strategy>> list(String source) {
                return R.fail("查询攻略列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<Strategy> getOne(Long id, String source) {
                return R.fail("查询攻略信息失败:" + throwable.getMessage());
            }

            @Override
            public R<?> statisRank(String source) {
                return R.fail("统计排行榜失败：" + throwable.getMessage());
            }

            @Override
            public R<?> statisCondition(String source) {
                return R.fail("统计条件排行数据失败：" + throwable.getMessage());
            }

            @Override
            public R<?> statisHashPersistence(String source) {
                return R.fail("统计数据持久化失败：" + throwable.getMessage());
            }
        };
    }
}
