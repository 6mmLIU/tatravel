package cn.wolfcode.wolf2w.business.listener;

import cn.wolfcode.wolf2w.business.domain.StrategyCanal;
import cn.wolfcode.wolf2w.common.rabbit.config.TravelRabbitConfig;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@Component
@CanalTable("ta_strategy")
public class StrategyLoginListener implements EntryHandler<StrategyCanal> {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void insert(StrategyCanal strategyCanal) {
        System.out.println("新增攻略" + strategyCanal);
        String message = JSON.toJSONString(strategyCanal);
        amqpTemplate.convertAndSend(TravelRabbitConfig.STRATEGY_EXCHANGE_NAME, TravelRabbitConfig.STRATEGY_ROUTING_KEY, message);
        //todo 同步信息到缓存库


        //todo 同步信息到日志库
    }

    @Override
    public void update(StrategyCanal before, StrategyCanal after) {

    }

    @Override
    public void delete(StrategyCanal strategyCanal) {

    }
}
