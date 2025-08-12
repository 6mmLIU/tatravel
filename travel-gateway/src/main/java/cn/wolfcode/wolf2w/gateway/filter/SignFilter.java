package cn.wolfcode.wolf2w.gateway.filter;

import cn.wolfcode.wolf2w.common.core.exception.ServiceException;
import cn.wolfcode.wolf2w.gateway.util.Md5Util;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class SignFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        Map<String, Object> map = new HashMap<>();
        for (String key : queryParams.keySet()) {
            if ("sign".equals(key)) {
                continue;
            }
            List<String> list = queryParams.get(key);
            StringBuffer sb = new StringBuffer();
            for (String s : list) {
                sb.append(s);
            }
            String value = sb.toString();
            map.put(key, value);
        }
        String sign_server = Md5Util.signatures(map);
        String sign_client = queryParams.getFirst("sign");
        //只有一个测试接口携带了签名,其他接口还没有实现,所以加入如下测试的代码
        //当所有接口都有签名时,删除该代码
        if (sign_client == null) {
            //放行
            return chain.filter(exchange);
        }
        if (sign_client.equals(sign_server)) {
            //签名正确
            //判断接口的时效性
            Long requestTime = Long.valueOf(queryParams.getFirst("timestamp"));
            long now = System.currentTimeMillis();
            if (now - requestTime > 20 * 1000) {
                throw new ServiceException("接口访问超时");
            }
            return chain.filter(exchange);
        } else {
            //签名异常
            throw new ServiceException("参数被篡改");
        }
    }
}
