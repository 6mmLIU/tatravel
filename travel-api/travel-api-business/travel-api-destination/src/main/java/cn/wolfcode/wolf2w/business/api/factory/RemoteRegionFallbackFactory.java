package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteRegionService;
import cn.wolfcode.wolf2w.business.api.domain.Region;
import cn.wolfcode.wolf2w.common.core.domain.R;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 区域 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteRegionFallbackFactory implements FallbackFactory<RemoteRegionService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteRegionFallbackFactory.class);

    @Override
    public RemoteRegionService create(Throwable throwable) {
        log.error("区域服务调用失败:{}", throwable.getMessage());

        return new RemoteRegionService() {
            @Override
            public R<List<Region>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询区域列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<Region> getOne(Long id, String source) {
                return R.fail("查询区域信息失败:" + throwable.getMessage());
            }
        };
    }
}
