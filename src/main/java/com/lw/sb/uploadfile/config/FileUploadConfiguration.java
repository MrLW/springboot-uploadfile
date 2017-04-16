package com.lw.sb.uploadfile.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * Created by lw on 2017/4/16.
 * 文件上传配置
 */

public class FileUploadConfiguration {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件上传大小
        factory.setMaxFileSize("5MB");
        //设置总上传大小
        factory.setMaxFileSize("10MB");

        return factory.createMultipartConfig();
    }
}
