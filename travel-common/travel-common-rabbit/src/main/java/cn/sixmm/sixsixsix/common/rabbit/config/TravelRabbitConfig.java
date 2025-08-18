package cn.sixmm.sixsixsix.common.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravelRabbitConfig {

    public static final String STRATEGY_QUEUE_NAME = "strategyQueue";
    public static final String STRATEGY_EXCHANGE_NAME = "strategyExchange";
    public static final String STRATEGY_ROUTING_KEY = "strategyKey";

    @Bean
    public Queue strategyQueue(){
        return new Queue(STRATEGY_QUEUE_NAME, true, false, false );
    }

    @Bean
    public DirectExchange strategyExchange(){
        return new DirectExchange(STRATEGY_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding strategyBinding(){
        return new Binding(STRATEGY_QUEUE_NAME, Binding.DestinationType.QUEUE, STRATEGY_EXCHANGE_NAME, STRATEGY_ROUTING_KEY, null);
    }


}
