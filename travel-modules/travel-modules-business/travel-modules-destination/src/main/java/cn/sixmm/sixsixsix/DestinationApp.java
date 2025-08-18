package cn.sixmm.sixsixsix;

import cn.sixmm.sixsixsix.common.security.annotation.EnableCustomConfig;
import cn.sixmm.sixsixsix.common.security.annotation.EnableRyFeignClients;
import cn.sixmm.sixsixsix.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomSwagger2
@SpringBootApplication
@EnableRyFeignClients(basePackages = "cn.sixmm.sixsixsix.destination.api")
@EnableCustomConfig
public class DestinationApp {
    public static void main(String[] args) {
        SpringApplication.run(DestinationApp.class, args);
    }
}
