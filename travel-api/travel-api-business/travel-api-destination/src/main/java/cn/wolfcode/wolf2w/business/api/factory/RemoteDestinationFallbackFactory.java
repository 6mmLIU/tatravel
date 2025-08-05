package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteDestinationService;
import cn.wolfcode.wolf2w.business.api.domain.Destination;
import cn.wolfcode.wolf2w.common.core.domain.R;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 目的地 远程服务降级回调
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteDestinationFallbackFactory implements FallbackFactory<RemoteDestinationService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteDestinationFallbackFactory.class);

    @Override
    public RemoteDestinationService create(final Throwable throwable) {
        log.error("目的地服务调用失败：{}", throwable.getMessage());
        return new RemoteDestinationService() {
            @Override
            public R<List<Destination>> list(Integer type,
                                             String name,
                                             Integer size,
                                             String source) {
                return R.fail(Lists.newArrayList(),
                        "查询目的地列表信息失败: " + throwable.getMessage());
            }

            @Override
            public R<Destination> getOne(Long id, String source) {
                return R.fail("查询目的地信息失败: " + throwable.getMessage());
            }

            @Override
            public R<Long> isAbroad(Long destId, String source) {
                return R.fail("查询国内国外失败: " + throwable.getMessage());
            }

            @Override
            public R<List<Destination>> list2(String source) {
                return R.fail(Lists.newArrayList(),
                        "查询所有目的地失败: " + throwable.getMessage());
            }
        };
    }
}
