package cn.sixmm.sixsixsix;

import cn.sixmm.sixsixsix.common.security.annotation.EnableCustomConfig;
import cn.sixmm.sixsixsix.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableRyFeignClients
@EnableCustomConfig
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ  会员模块启动成功   ლ(´ڡ`ლ)ﾞ ");
    }
}
