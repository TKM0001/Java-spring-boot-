package com.example.springbootlearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Web 配置类
 * 
 * @Configuration: 标记为配置类，相当于 Spring 的 XML 配置文件
 * 
 * 用于配置跨域请求、拦截器、过滤器等 Web 相关配置
 */
@Configuration
public class WebConfig {

    /**
     * 配置跨域请求（CORS）
     * 允许前端应用从不同域名访问后端 API
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        
        // 允许的源（域名）- 开发环境允许所有来源
        config.addAllowedOriginPattern("*");
        
        // 允许的 HTTP 方法
        config.addAllowedMethod("*");
        
        // 允许的请求头
        config.addAllowedHeader("*");
        
        // 允许携带凭证（Cookie 等）
        config.setAllowCredentials(true);
        
        // 预检请求的缓存时间（秒）
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
