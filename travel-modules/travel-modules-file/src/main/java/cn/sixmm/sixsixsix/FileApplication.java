package cn.sixmm.sixsixsix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import cn.sixmm.sixsixsix.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(FileApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  文件服务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
