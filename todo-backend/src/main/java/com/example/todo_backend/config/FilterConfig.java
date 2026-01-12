package com.example.todo_backend.config;

import com.example.todo_backend.filter.JwtAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class FilterConfig {

    // CORS Filter（最優先）
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistration(
            CorsFilter corsFilter
    ) {
        FilterRegistrationBean<CorsFilter> bean =
                new FilterRegistrationBean<>();

        bean.setFilter(corsFilter);
        bean.addUrlPatterns("/*");
        bean.setOrder(1); // ★ 最優先

        return bean;
    }

    // JWT Filter（CORS の後）
    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilterRegistration() {
        FilterRegistrationBean<JwtAuthenticationFilter> bean =
                new FilterRegistrationBean<>();

        bean.setFilter(new JwtAuthenticationFilter());
        bean.addUrlPatterns("/api/*");
        bean.setOrder(2); // ★ CORS の後

        return bean;
    }
}
