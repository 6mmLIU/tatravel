package cn.wolfcode.wolf2w.canalapp;

import cn.wolfcode.wolf2w.common.security.annotation.EnableCustomConfig;
import cn.wolfcode.wolf2w.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(
        scanBasePackages = {// 只扫描 Canal 相关的组件
                "cn.wolfcode.wolf2w.common.security"   // 如果 CustomConfig/Feign 在这里
        },
        exclude = {
                DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                JdbcTemplateAutoConfiguration.class,
                DruidDataSourceAutoConfigure.class,
                MybatisAutoConfiguration.class,
                MybatisPlusAutoConfiguration.class
        }
)
@EnableRyFeignClients(basePackages = {
        "cn.wolfcode.wolf2w.canalapp",
        "cn.wolfcode.wolf2w.system.api"
})
@EnableCustomConfig
@MapperScan(" ")  // 如果 canalapp 真没 mapper，就指定一个空包也行
public class CanalApp {
    public static void main(String[] args) {
        SpringApplication.run(CanalApp.class, args);
    }
}
