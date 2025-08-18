package cn.sixmm.sixsixsix.file.service.impl;

import cn.sixmm.sixsixsix.file.config.MinioConfig;
import cn.sixmm.sixsixsix.file.config.QiniuConfig;
import cn.sixmm.sixsixsix.file.service.ISysFileService;
import cn.sixmm.sixsixsix.file.utils.FileUploadUtils;
import com.alibaba.nacos.common.utils.IoUtils;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * qiniu 文件存储
 *
 * @author ruoyi
 */
@Service
@ConditionalOnProperty(prefix = "store", name = "type", havingValue = "qiniu")
public class QinuSysFileServiceImpl implements ISysFileService
{
    @Autowired
    private QiniuConfig qiniuConfig;

    /**
     * qiniu文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception
    {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region1());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = qiniuConfig.getAccessKey();
        String secretKey = qiniuConfig.getSecretKey();
        String bucket = qiniuConfig.getBucketName();
        String originalFilename = file.getOriginalFilename();
        //文件后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = UUID.randomUUID().toString()  + suffix;

        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(file.getInputStream(),key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return qiniuConfig.getUrl()+"/"+key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        }
        return null;
    }
}
