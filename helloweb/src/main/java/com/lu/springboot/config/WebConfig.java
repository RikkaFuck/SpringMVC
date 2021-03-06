package com.lu.springboot.config;

import com.lu.springboot.args.UserResolver;
import com.lu.threadpool.spring.aop.TimeCounterAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * <pre>
 * <b>描述信息</b>
 * <b>Description:If you want to take complete control of Spring MVC, you can add your own @Configuration annotated with @EnableWebMvc.</b>
 *  除非完全的MVC控制，否則不要使用@EnableMvc注解
 * <b>Author:</b> Luyongjia
 * <b>Date:</b> 2017年03月08日  14:29
 * <b>Changelog:</b>
 *   Ver   Date                             Author                Detail
 *   ----------------------------------------------------------------------
 *   0.1   2017年03月08日  14:29   Luyongjia
 *         new file.
 * </pre>
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public TimeCounterAdvice timeCounterAdvice() {
        return new TimeCounterAdvice();
    }

}
