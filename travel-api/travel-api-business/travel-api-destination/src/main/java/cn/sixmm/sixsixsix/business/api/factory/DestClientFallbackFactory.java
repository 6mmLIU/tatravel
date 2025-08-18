package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.DestClient;
import cn.sixmm.sixsixsix.common.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DestClientFallbackFactory implements FallbackFactory<DestClient> {
    @Override
    public DestClient create(Throwable cause){
        log.error("[DestClient]调用travel-destination 失败",cause);
        return ((type, name) -> R.fail("目的地服务暂不可用"));
    }
}
