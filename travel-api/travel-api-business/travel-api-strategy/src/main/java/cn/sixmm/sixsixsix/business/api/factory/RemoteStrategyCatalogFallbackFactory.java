package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteStrategyCatalogService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.StrategyCatalog;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 攻略分类 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteStrategyCatalogFallbackFactory implements FallbackFactory<RemoteStrategyCatalogService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteStrategyCatalogFallbackFactory.class);

    @Override
    public RemoteStrategyCatalogService create(Throwable throwable) {
        log.error("攻略分类服务调用失败:{}", throwable.getMessage());

        return new RemoteStrategyCatalogService() {
            @Override
            public R<List<StrategyCatalog>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询攻略分类列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<StrategyCatalog> getOne(Long id, String source) {
                return R.fail("查询攻略分类信息失败:" + throwable.getMessage());
            }
        };
    }
}
