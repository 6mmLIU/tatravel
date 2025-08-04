package cn.wolfcode.wolf2w;

import cn.wolfcode.wolf2w.common.security.annotation.EnableCustomConfig;
import cn.wolfcode.wolf2w.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableRyFeignClients
@EnableCustomConfig
@SpringBootApplication
public class AnswerApp {
    public static void main(String[] args) {
      SpringApplication.run(AnswerApp.class,args);
    }
}
