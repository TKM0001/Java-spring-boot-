package com.example.springbootlearning.controller;

import com.example.springbootlearning.model.ApiResponse;
import com.example.springbootlearning.model.User;
import com.example.springbootlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 * 
 * @RestController: 标记为 REST 控制器，返回 JSON 格式数据
 * @RequestMapping: 定义 URL 路径前缀
 * 
 * 控制器层（Controller Layer）职责：
 * 1. 接收 HTTP 请求
 * 2. 参数验证
 * 3. 调用 Service 层处理业务逻辑
 * 4. 返回响应结果
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    // 依赖注入：自动注入 UserService
    @Autowired
    private UserService userService;

    /**
     * GET 请求示例：获取所有用户
     * 访问地址: GET http://localhost:8080/api/users
     */
    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ApiResponse.success("获取用户列表成功", users);
    }

    /**
     * GET 请求示例：根据 ID 获取用户
     * 访问地址: GET http://localhost:8080/api/users/1
     * 
     * @PathVariable: 从 URL 路径中获取参数
     */
    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ApiResponse.error(404, "用户不存在");
        }
        return ApiResponse.success("获取用户成功", user);
    }

    /**
     * POST 请求示例：创建新用户
     * 访问地址: POST http://localhost:8080/api/users
     * 请求体: {"name": "测试用户", "email": "test@test.com", "age": 25}
     * 
     * @RequestBody: 从请求体中获取 JSON 数据并转换为对象
     */
    @PostMapping
    public ApiResponse<User> createUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return ApiResponse.error(400, "用户名不能为空");
        }
        User createdUser = userService.createUser(user);
        return ApiResponse.success("用户创建成功", createdUser);
    }

    /**
     * PUT 请求示例：更新用户信息
     * 访问地址: PUT http://localhost:8080/api/users/1
     */
    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser == null) {
            return ApiResponse.error(404, "用户不存在");
        }
        return ApiResponse.success("用户更新成功", updatedUser);
    }

    /**
     * DELETE 请求示例：删除用户
     * 访问地址: DELETE http://localhost:8080/api/users/1
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (!deleted) {
            return ApiResponse.error(404, "用户不存在");
        }
        return ApiResponse.success("用户删除成功", null);
    }

    /**
     * 自定义查询：统计用户数量
     * 访问地址: GET http://localhost:8080/api/users/count
     */
    @GetMapping("/count")
    public ApiResponse<Long> countUsers() {
        long count = userService.countUsers();
        return ApiResponse.success("当前用户数量: " + count, count);
    }
}
