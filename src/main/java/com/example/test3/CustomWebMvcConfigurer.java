package com.example.test3;

import com.example.test3.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册多个Interceptor  注意路径的写法
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api/**");
        //registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");
        //注册某个拦截器的时候，同时排除某些不拦截的路径
        //registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**").excludePathPatterns("/api2/xxx/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
