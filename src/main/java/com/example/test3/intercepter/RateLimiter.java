package com.example.test3.intercepter;

import java.lang.annotation.*;

/**
 * @author
 * @version 1.0
 * @date
 * @className RateLimiter
 * @desc 限流注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {

    /**
     * 限流key
     * @return
     */
    String key() default "rate:limiter";
    /**
     * 单位时间限制通过请求数
     * @return
     */
    long limit() default 10;

    /**
     * 过期时间，单位秒
     * @return
     */
    long expire() default 1;

    /**
     * 限流提示语
     * @return
     */
    String message() default "false";
}
