package cn.sixmm.sixsixsix.business.listener;

import cn.sixmm.sixsixsix.business.api.domain.Strategy;
import cn.sixmm.sixsixsix.business.service.IStrategyService;
import cn.sixmm.sixsixsix.common.redis.service.RedisService;
import cn.sixmm.sixsixsix.common.redis.util.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StrategyHashInitListener implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private IStrategyService strategyService;
    @Autowired
    private RedisService redisService;

    /**
     * 当事件到来的执行方法
     * 参数:事件对象
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        //预热数据(近期的热门数据)
        List<Strategy> list = strategyService.list();
        for (Strategy strategy : list) {
            String key = RedisKeys.STRATEGY_STATUS_HASH.join(strategy.getId().toString());
            if (redisService.hasKey(key)) {
                continue;
            }
            Map map = new HashMap();
            map.put("id", strategy.getId());
            map.put("viewnum", Integer.valueOf(strategy.getViewnum().toString()));
            map.put("replynum", Integer.valueOf(strategy.getReplynum().toString()));
            map.put("favornum", Integer.valueOf(strategy.getFavornum().toString()));
            map.put("sharenum", Integer.valueOf(strategy.getSharenum().toString()));
            map.put("thumbsupnum", Integer.valueOf(strategy.getThumbsupnum().toString()));
            redisService.setCacheMap(key, map);
        }
        System.out.println("攻略统计hash数据初始化完成");

    }
}
