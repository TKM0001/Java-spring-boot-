package com.example.springbootlearning.controller;

import com.example.springbootlearning.model.User;
import com.example.springbootlearning.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 用户控制器集成测试
 * 
 * 使用 MockMvc 模拟 HTTP 请求进行测试
 * 不需要启动真实的 HTTP 服务器
 */
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        // 每个测试前可以初始化数据
        System.out.println("开始执行测试...");
    }

    @Test
    @DisplayName("获取所有用户 - 应返回用户列表")
    void getAllUsers_ShouldReturnUserList() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data", hasSize(greaterThan(0))));
    }

    @Test
    @DisplayName("根据 ID 获取用户 - 应返回指定用户")
    void getUserById_WhenUserExists_ShouldReturnUser() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.name").exists());
    }

    @Test
    @DisplayName("根据 ID 获取用户 - 用户不存在时应返回404")
    void getUserById_WhenUserNotFound_ShouldReturn404() throws Exception {
        mockMvc.perform(get("/api/users/99999"))
                .andExpect(status().isOk()) // 我们返回200但code是404
                .andExpect(jsonPath("$.code").value(404));
    }

    @Test
    @DisplayName("创建新用户 - 应成功创建")
    void createUser_WithValidData_ShouldCreateUser() throws Exception {
        String newUserJson = "{\"name\":\"测试用户\",\"email\":\"test@test.com\",\"age\":25}";

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newUserJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.name").value("测试用户"));
    }

    @Test
    @DisplayName("创建用户 - 姓名为空时应返回400")
    void createUser_WithEmptyName_ShouldReturn400() throws Exception {
        String invalidUserJson = "{\"name\":\"\",\"email\":\"test@test.com\",\"age\":25}";

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidUserJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(400));
    }

    @Test
    @DisplayName("Hello 接口 - 应返回欢迎信息")
    void hello_ShouldReturnWelcomeMessage() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.welcomeMessage").exists());
    }
}
