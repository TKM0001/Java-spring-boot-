package com.example.springbootlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用程序的主入口类
 * 
 * @SpringBootApplication 注解说明：
 * 1. @Configuration: 标记为配置类
 * 2. @EnableAutoConfiguration: 启用自动配置
 * 3. @ComponentScan: 自动扫描当前包及子包中的组件
 */
@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(SpringBootLearningApplication.class, args);
        System.out.println("========================================");
        System.out.println("🚀 Spring Boot 学习项目启动成功！");
        System.out.println("访问地址: http://localhost:8080");
        System.out.println("API 文档: http://localhost:8080/api/hello");
        System.out.println("========================================");
    }
}
