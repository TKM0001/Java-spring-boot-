package com.example.springbootlearning.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器 - 用户认证功能
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    /**
     * 用户登录
     * POST http://localhost:8080/api/auth/login
     *
     * @param body 包含 username 和 password 的请求体
     * @return 登录结果（成功返回 token，失败返回错误信息）
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        Map<String, Object> response = new HashMap<>();

        String username = body.get("username");
        String password = body.get("password");

        if (username == null || password == null) {
            response.put("success", false);
            response.put("message", "用户名和密码不能为空");
            return response;
        }

        // 模拟用户验证（实际项目中应该查询数据库）
        if ("admin".equals(username) && "123456".equals(password)) {
            response.put("success", true);
            response.put("message", "登录成功");
            response.put("token", "mock-jwt-token-" + System.currentTimeMillis());
            response.put("user", Map.of(
                "username", username,
                "role", "admin"
            ));
        } else {
            response.put("success", false);
            response.put("message", "用户名或密码错误");
        }

        return response;
    }

    /**
     * 用户注册
     * POST http://localhost:8080/api/auth/register
     */
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> body) {
        Map<String, Object> response = new HashMap<>();

        String username = body.get("username");
        String password = body.get("password");

        if (username == null || password == null) {
            response.put("success", false);
            response.put("message", "用户名和密码不能为空");
            return response;
        }

        if (password.length() < 6) {
            response.put("success", false);
            response.put("message", "密码长度不能少于6位");
            return response;
        }

        // 模拟注册成功
        response.put("success", true);
        response.put("message", "注册成功");
        response.put("userId", System.currentTimeMillis());

        return response;
    }
}