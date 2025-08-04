package cn.wolfcode.wolf2w;

import cn.wolfcode.wolf2w.common.security.annotation.EnableCustomConfig;
import cn.wolfcode.wolf2w.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRyFeignClients(basePackages = "cn.wolfcode.wolf2w.destination.api")
@EnableCustomConfig
public class DestinationApp {
    public static void main(String[] args) {
        SpringApplication.run(DestinationApp.class, args);
    }
}
