package cn.sixmm.sixsixsix.file.service.impl;

import cn.sixmm.sixsixsix.file.config.AliOssConfig;
import cn.sixmm.sixsixsix.file.config.QiniuConfig;
import cn.sixmm.sixsixsix.file.service.ISysFileService;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Minio 文件存储
 *
 * @author ruoyi
 */
@Service
@ConditionalOnProperty(prefix = "store", name = "type", havingValue = "alioss")
public class AliOssSysFileServiceImpl implements ISysFileService
{
    @Autowired
    private AliOssConfig aliOssConfig;

    /**
     * alioss文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception
    {
        //生成文件名称
        String uuid = UUID.randomUUID().toString();
        String orgFileName = file.getOriginalFilename();//获取真实文件名称 xxx.jpg
        String ext= "." + FilenameUtils.getExtension(orgFileName);//获取拓展名字.jpg
        String fileName =uuid + ext;//xxxxxsfsasa.jpg


        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = aliOssConfig.getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = aliOssConfig.getAccessKey();
        String accessKeySecret =aliOssConfig.getSecretKey();
        // 填写Bucket名称，例如examplebucket。
        String bucketName =aliOssConfig.getBucketName();
        // 填写网络流地址。
        String url = aliOssConfig.getUrl();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file.getInputStream());
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            return url + fileName;
        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (ClientException ce) {
            ce.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }
}
