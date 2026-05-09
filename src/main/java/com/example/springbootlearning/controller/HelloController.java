package com.example.springbootlearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello World 控制器 - 最简单的 REST API 示例
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    // 从配置文件中读取属性值
    @Value("${app.welcome.message}")
    private String welcomeMessage;

    @Value("${app.author.name}")
    private String authorName;

    /**
     * 最简单的 GET 请求示例
     * 访问地址: GET http://localhost:8080/api/hello
     */
    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello, Spring Boot! 🎉");
        response.put("welcomeMessage", welcomeMessage);
        response.put("author", authorName);
        response.put("tips", "恭喜你成功运行了第一个 Spring Boot 应用！");
        return response;
    }

    /**
     * 返回不同类型的响应
     * 访问地址: GET http://localhost:8080/api/info
     */
    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("appName", "Spring Boot 学习项目");
        info.put("version", "1.0.0");
        info.put("description", "这是一个用于学习 Java 和 Spring Boot 的简单项目");
        
        Map<String, String> features = new HashMap<>();
        features.put("框架", "Spring Boot 3.2.0");
        features.put("Java版本", "17");
        features.put("构建工具", "Maven");
        features.put("架构风格", "RESTful API");
        info.put("技术栈", features);

        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("Hello World", "GET /api/hello");
        endpoints.put("项目信息", "GET /api/info");
        endpoints.put("用户列表", "GET /api/users");
        endpoints.put("创建用户", "POST /api/users");
        endpoints.put("获取用户", "GET /api/users/{id}");
        endpoints.put("更新用户", "PUT /api/users/{id}");
        endpoints.put("删除用户", "DELETE /api/users/{id}");
        endpoints.put("用户统计", "GET /api/users/count");
        info.put("可用接口", endpoints);

        return info;
    }
}
