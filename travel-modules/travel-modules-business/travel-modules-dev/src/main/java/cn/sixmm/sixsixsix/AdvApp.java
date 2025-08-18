package cn.sixmm.sixsixsix;

import cn.sixmm.sixsixsix.common.security.annotation.EnableCustomConfig;
import cn.sixmm.sixsixsix.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCustomConfig
@EnableRyFeignClients
public class AdvApp {
    public static void main(String[] args) {
        SpringApplication.run(AdvApp.class,args);
    }
}
