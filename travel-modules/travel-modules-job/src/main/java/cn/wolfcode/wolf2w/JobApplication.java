package cn.wolfcode.wolf2w;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cn.wolfcode.wolf2w.common.security.annotation.EnableCustomConfig;
import cn.wolfcode.wolf2w.common.security.annotation.EnableRyFeignClients;
import cn.wolfcode.wolf2w.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients   
@SpringBootApplication
public class JobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(JobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
