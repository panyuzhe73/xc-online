package com.xuecheng.media.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient minioClient(){
         MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint) //Minio地址+服务端口
                        .credentials(accessKey, secretKey)//用户名+密码
                        .build();
         return minioClient;
    }

}
