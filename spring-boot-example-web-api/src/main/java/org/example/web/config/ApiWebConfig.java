package org.example.web.config;

import org.example.web.interceptor.ApiWebInterceptor;
import org.example.web.interceptor.ApiWebLoginHandlerInterceptor;
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
        registry.addInterceptor(new ApiWebLoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**", "/demo/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("{}->addCorsMappings()", this.getClass().getName());
        registry.addMapping("/**") // 允许所有请求路径跨域访问
                .allowCredentials(true) // 是否携带Cookie，默认false
                .allowedOriginPatterns("http://app.dcr.com")
//                .allowedHeaders("Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,Access-Control-Allow-Headers")    // 允许的请求头类型
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")    // 允许的请求方法类型
//                .allowedOrigins("http://app.dcr.com")    // 允许哪些域名进行跨域访问（http://127.0.0.1:8082）
                .maxAge(3600);          // 预检请求的缓存时间（单位：秒）
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
