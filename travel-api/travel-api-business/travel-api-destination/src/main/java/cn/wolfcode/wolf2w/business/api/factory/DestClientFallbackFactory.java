package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.DestClient;
import cn.wolfcode.wolf2w.common.core.domain.R;
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
