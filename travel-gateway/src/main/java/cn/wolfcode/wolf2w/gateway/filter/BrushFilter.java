package cn.wolfcode.wolf2w.gateway.filter;

import cn.wolfcode.wolf2w.common.core.exception.ServiceException;
import cn.wolfcode.wolf2w.common.redis.service.RedisService;
import cn.wolfcode.wolf2w.common.redis.util.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

//@Component
public class BrushFilter implements GlobalFilter {

    @Autowired
    private RedisService redisService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();
        String ip = exchange.getRequest().getRemoteAddress().getHostName();
        String key = RedisKeys.BRUSH.join(path, ip);
        redisService.setNxCacheObject(key, 0, RedisKeys.BRUSH.getTime(), TimeUnit.SECONDS);
        Long ret = redisService.incrementCacheObjectValue(key, 1);
        if(ret < 20){
            //直接放行
            return chain.filter(exchange);
        }else{
            //恶意刷新
            throw  new ServiceException("请勿恶意刷新");
        }
    }
}
