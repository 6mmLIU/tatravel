package cn.wolfcode.wolf2w.bussiness.util;

import cn.wolfcode.wolf2w.common.core.exception.ServiceException;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class SmsUtil {
    public static void sendSmsAli(String phone, String code) {
            String host = "https://smsv2.market.alicloudapi.com";
            String path = "/sms/sendv2";
            String method = "POST";
            String appcode = "db01c8b7a22f49e2a762b6ea78316bd9";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            //根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            Map<String, String> bodys = new HashMap<String, String>();
            bodys.put("mobile", phone);
            bodys.put("content", "【智能云】您的验证码是"+code+"。如非本人操作，请忽略本短信");


            try {
                /**
                 * 重要提示如下:
                 * HttpUtils请从
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                 * 下载
                 *
                 * 相应的依赖请参照
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                 */
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServiceException("验证码发送失败");
            }
        }

    }

