package cn.wolfcode.wolf2w;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cn.wolfcode.wolf2w.common.security.annotation.EnableCustomConfig;
import cn.wolfcode.wolf2w.common.security.annotation.EnableRyFeignClients;
import cn.wolfcode.wolf2w.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@MapperScan("cn.wolfcode.wolf2w.system.mapper")
@SpringBootApplication
public class SystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
