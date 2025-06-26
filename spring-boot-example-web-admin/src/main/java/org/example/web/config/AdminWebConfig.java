package org.example.web.config;

import org.example.web.interceptor.AdminWebInterceptor;
import org.example.web.interceptor.AdminWebLoginHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    private static Logger logger = LoggerFactory.getLogger(AdminWebConfig.class);
    /**
     * 注册拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("{}->addInterceptors()", this.getClass().getName());
        registry.addInterceptor(new AdminWebInterceptor());
        registry.addInterceptor(new AdminWebLoginHandlerInterceptor()).addPathPatterns("/user/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
