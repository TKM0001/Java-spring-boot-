package com.example.springbootlearning.service;

import com.example.springbootlearning.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户服务类
 * 
 * @Service: 标记为服务层组件，Spring 会自动扫描并注册为 Bean
 * 
 * 服务层（Service Layer）职责：
 * 1. 处理业务逻辑
 * 2. 数据处理和转换
 * 3. 事务管理
 */
@Service
public class UserService {
    
    // 模拟数据库存储
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UserService() {
        // 初始化一些测试数据
        users.add(new User(idGenerator.getAndIncrement(), "张三", "zhangsan@example.com", 25));
        users.add(new User(idGenerator.getAndIncrement(), "李四", "lisi@example.com", 30));
        users.add(new User(idGenerator.getAndIncrement(), "王五", "wangwu@example.com", 28));
    }

    /**
     * 获取所有用户
     */
    public List<User> getAllUsers() {
        System.out.println("获取所有用户，当前用户数量: " + users.size());
        return new ArrayList<>(users);
    }

    /**
     * 根据 ID 获取用户
     */
    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * 创建新用户
     */
    public User createUser(User user) {
        user.setId(idGenerator.getAndIncrement());
        users.add(user);
        System.out.println("创建新用户: " + user.getName());
        return user;
    }

    /**
     * 更新用户信息
     */
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setAge(userDetails.getAge());
            System.out.println("更新用户信息: " + user.getName());
        }
        return user;
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(Long id) {
        boolean removed = users.removeIf(user -> user.getId().equals(id));
        if (removed) {
            System.out.println("删除用户 ID: " + id);
        }
        return removed;
    }

    /**
     * 统计用户数量
     */
    public long countUsers() {
        return users.size();
    }
}
