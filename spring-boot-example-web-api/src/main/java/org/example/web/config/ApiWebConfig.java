package org.example.web.config;

import org.example.web.interceptor.ApiWebInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiWebConfig implements WebMvcConfigurer {

    private static Logger logger = LoggerFactory.getLogger(ApiWebConfig.class);
    /**
     * 注册拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("{}->addInterceptors()", this.getClass().getName());
        registry.addInterceptor(new ApiWebInterceptor());
//        registry.addInterceptor(new ApiWebLoginHandlerInterceptor()).excludePathPatterns("/login/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("{}->addCorsMappings()", this.getClass().getName());
        registry.addMapping("/**") // 允许所有请求路径跨域访问
                .allowCredentials(true) // 是否携带Cookie，默认false
                .allowedHeaders("*")    // 允许的请求头类型
                .allowedMethods("*")    // 允许的请求方法类型
                .allowedOrigins("*")    // 允许哪些域名进行跨域访问（http://127.0.0.1:8082）
                .maxAge(3600);          // 预检请求的缓存时间（单位：秒）
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
