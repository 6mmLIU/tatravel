package cn.wolfcode.wolf2w;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cn.wolfcode.wolf2w.common.security.annotation.EnableCustomConfig;
import cn.wolfcode.wolf2w.common.security.annotation.EnableRyFeignClients;
import cn.wolfcode.wolf2w.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class GenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
