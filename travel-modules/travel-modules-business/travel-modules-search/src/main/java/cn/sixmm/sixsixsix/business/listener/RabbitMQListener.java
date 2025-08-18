package cn.sixmm.sixsixsix.business.listener;

import cn.sixmm.sixsixsix.business.api.domain.Strategy;
import cn.sixmm.sixsixsix.business.api.domain.StrategyES;
import cn.sixmm.sixsixsix.business.respository.StrategyEsRepository;
import cn.sixmm.sixsixsix.common.rabbit.config.TravelRabbitConfig;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Autowired
    private StrategyEsRepository repository;

    @RabbitListener(queues = {TravelRabbitConfig.STRATEGY_QUEUE_NAME})
    public void onMessage(String message) {
        Strategy strategy = JSON.parseObject(message, Strategy.class);
        StrategyES es = new StrategyES();
        BeanUtils.copyProperties(strategy, es);
        repository.save(es);
    }
}
