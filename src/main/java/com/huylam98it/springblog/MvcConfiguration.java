package com.huylam98it.springblog;

import com.huylam98it.springblog.controller.PreInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    public Environment env;

    @Autowired
    public PreInterceptor preInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("upload folder: "+"file:"+env.getProperty("upload.folder"));
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+env.getProperty("upload.folder"));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(preInterceptor).addPathPatterns("/*");
    }
}
