package cn.wolfcode.wolf2w.job.task;

import cn.wolfcode.wolf2w.business.api.RemoteStrategyService;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("strategyTask")
@Slf4j
public class StrategyTask {
    @Autowired
    RemoteStrategyService remoteStrategyService;

    public void statisRank() {
        System.out.println(">>> strategyTask.statisRank() in Quartz thread");
        log.info(">>> strategyTask.statisRank() start");
        try {
            R<?> ret = remoteStrategyService.statisRank(SecurityConstants.INNER);
            log.info("job 调 feign result: {}", ret);
        } catch (Exception e) {
            log.error("job 调用 feign 异常", e);
        }
        log.info("<<< strategyTask.statisRank() end");
    }

    public void statisCondition() {
        System.out.println("条件排行数据统计任务");
        remoteStrategyService.statisCondition(SecurityConstants.INNER);

    }

    public void statisHashPersistence() {
        remoteStrategyService.statisHashPersistence("inner");
    }
}

