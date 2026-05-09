# 🚀 Spring Boot 学习项目

## 📋 项目简介

这是一个专门为初学者设计的 **Java Spring Boot** 学习项目，涵盖了 Spring Boot 的核心概念和最佳实践。

## 🛠️ 技术栈

- **Java**: 17
- **Spring Boot**: 3.2.0
- **构建工具**: Maven
- **架构风格**: RESTful API

## 📁 项目结构

```
springboot-learning/
├── pom.xml                                    # Maven 配置文件
├── src/
│   ├── main/
│   │   ├── java/com/example/springbootlearning/
│   │   │   ├── SpringBootLearningApplication.java  # 应用程序主入口
│   │   │   ├── config/                              # 配置类
│   │   │   │   └── WebConfig.java                   # Web配置（跨域等）
│   │   │   ├── controller/                          # 控制器层（API接口）
│   │   │   │   ├── HelloController.java             # Hello World示例
│   │   │   │   └── UserController.java              # 用户管理API
│   │   │   ├── exception/                           # 异常处理
│   │   │   │   ├── BusinessException.java           # 自定义业务异常
│   │   │   │   └── GlobalExceptionHandler.java      # 全局异常处理器
│   │   │   ├── model/                               # 数据模型
│   │   │   │   ├── ApiResponse.java                 # 统一响应格式
│   │   │   │   └── User.java                        # 用户实体类
│   │   │   └── service/                             # 服务层（业务逻辑）
│   │   │       └── UserService.java                 # 用户服务
│   │   └── resources/
│   │       └── application.properties               # 应用配置文件
│   └── test/                                        # 测试代码
│       └── java/com/example/springbootlearning/
│           ├── SpringBootLearningApplicationTests.java  # 基础测试
│           └── controller/
│               └── UserControllerTest.java              # 控制器测试
```

## 🎯 核心概念学习路径

### 1️⃣ **Spring Boot 基础**
- ✅ `@SpringBootApplication` - 应用启动注解
- ✅ 自动配置机制
- ✅ 内嵌服务器（Tomcat）

### 2️⃣ **依赖注入（DI）与控制反转（IoC）**
- ✅ `@Autowired` - 自动注入
- ✅ `@Service` - 服务层组件
- ✅ `@Component` - 通用组件
- ✅ Bean 的生命周期

### 3️⃣ **RESTful API 开发**
- ✅ `@RestController` - REST控制器
- ✅ `@RequestMapping` / `@GetMapping` / `@PostMapping` 等 - HTTP方法映射
- ✅ `@PathVariable` - URL路径参数
- ✅ `@RequestBody` - 请求体参数
- ✅ JSON 数据自动序列化/反序列化

### 4️⃣ **分层架构**
- **Controller层**: 处理HTTP请求和响应
- **Service层**: 业务逻辑处理
- **Model层**: 数据模型定义
- **Exception层**: 统一异常处理

### 5️⃣ **配置管理**
- ✅ `application.properties` - 配置文件
- ✅ `@Value` - 注入配置属性
- ✅ 多环境配置支持

### 6️⃣ **异常处理**
- ✅ `@ControllerAdvice` / `@RestControllerAdvice` - 全局异常处理
- ✅ 自定义异常类
- ✅ 统一错误响应格式

### 7️⃣ **测试**
- ✅ `@SpringBootTest` - 集成测试
- ✅ MockMvc - 模拟HTTP请求测试
- ✅ 单元测试和集成测试

## 🔧 环境要求

- **JDK**: 17 或更高版本
- **Maven**: 3.8+
- **IDE**: IntelliJ IDEA / Eclipse / VS Code

## ⚡ 快速开始

### 1. 安装依赖
```bash
cd springboot-learning
mvn clean install
```

### 2. 启动应用
```bash
# 方式一：使用 Maven
mvn spring-boot:run

# 方式二：直接运行主类
# 在 IDE 中运行 SpringBootLearningApplication.java 的 main 方法
```

### 3. 访问应用
启动成功后，访问以下地址：

- 🏠 **首页信息**: http://localhost:8080/api/info
- 👋 **Hello World**: http://localhost:8080/api/hello
- 👥 **用户列表**: http://localhost:8080/api/users

## 📡 API 接口文档

### 基础接口

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/hello` | Hello World 示例 |
| GET | `/api/info` | 项目信息和可用接口 |

### 用户管理接口（CRUD）

| 方法 | 路径 | 说明 | 请求示例 |
|------|------|------|----------|
| GET | `/api/users` | 获取所有用户 | - |
| GET | `/api/users/{id}` | 根据ID获取用户 | - |
| POST | `/api/users` | 创建用户 | 见下方示例 |
| PUT | `/api/users/{id}` | 更新用户信息 | 见下方示例 |
| DELETE | `/api/users/{id}` | 删除用户 | - |
| GET | `/api/users/count` | 统计用户数量 | - |

#### 创建用户请求示例：
```json
{
    "name": "张三",
    "email": "zhangsan@example.com",
    "age": 25
}
```

#### 响应格式：
```json
{
    "code": 200,
    "message": "操作成功",
    "data": { ... },
    "timestamp": "2024-01-01T12:00:00"
}
```

## 🧪 运行测试

```bash
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=UserControllerTest

# 运行并生成报告
mvn test -Dsurefire.useFile=false
```

## 📚 学习建议

### 第一步：理解项目结构
1. 从 [SpringBootLearningApplication.java](src/main/java/com/example/springbootlearning/SpringBootLearningApplication.java) 开始，了解应用如何启动
2. 查看 [application.properties](src/main/resources/application.properties) 了解配置项

### 第二步：学习 Controller 层
1. 先看简单的 [HelloController.java](src/main/java/com/example/springbootlearning/controller/HelloController.java)
2. 再看完整的 [UserController.java](src/main/java/com/example/springbootlearning/controller/UserController.java)

### 第三步：理解 Service 层
1. 研究 [UserService.java](src/main/java/com/example/springbootlearning/service/UserService.java) 的业务逻辑
2. 理解依赖注入的工作原理

### 第四步：掌握数据模型
1. 查看 [User.java](src/main/java/com/example/springbootlearning/model/User.java) 实体类
2. 了解 [ApiResponse.java](src/main/java/com/example/springbootlearning/model/ApiResponse.java) 统一响应格式

### 第五步：学习异常处理
1. 阅读 [GlobalExceptionHandler.java](src/main/java/com/example/springbootlearning/exception/GlobalExceptionHandler.java)
2. 理解自定义异常 [BusinessException.java](src/main/java/com/example/springbootlearning/exception/BusinessException.java)

### 第六步：实践测试
1. 运行 [UserControllerTest.java](src/test/java/com/example/springbootlearning/controller/UserControllerTest.java)
2. 尝试编写自己的测试用例

## 🔍 推荐学习工具

### API 测试工具
- **Postman**: 强大的 API 测试客户端
- **curl**: 命令行 HTTP 客户端
- **浏览器扩展**: Talend API Tester

### IDE 推荐
- **IntelliJ IDEA Ultimate**: 对 Spring Boot 支持最好
- **VS Code + Extension Pack for Java**: 免费轻量级选择

### 其他有用工具
- **Swagger/OpenAPI**: API 文档自动生成
- **Actuator**: 应用监控和管理端点

## 💡 扩展学习方向

掌握了这个项目后，你可以继续学习：

1. **数据库集成**: Spring Data JPA、MyBatis
2. **安全框架**: Spring Security
3. **缓存技术**: Redis、Caffeine
4. **消息队列**: RabbitMQ、Kafka
5. **微服务**: Spring Cloud
6. **容器化**: Docker、Kubernetes

## ❓ 常见问题

### Q: 如何修改端口号？
A: 在 `application.properties` 中修改 `server.port=8080`

### Q: 如何添加新的 API？
A: 
1. 在 `controller` 包下创建新的 Controller 类
2. 使用 `@RestController` 和 `@RequestMapping` 注解
3. 编写对应的方法和 HTTP 映射

### Q: 如何连接数据库？
A:
1. 在 `pom.xml` 添加数据库依赖（如 MySQL、H2）
2. 在 `application.properties` 配置数据库连接
3. 创建 Entity 类和 Repository 接口

## 📖 参考资源

- [Spring Boot 官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Guides](https://spring.io/guides)
- [Baeldung Spring Boot 教程](https://www.baeldung.com/spring-boot)

---

**🎉 祝你学习愉快！如有问题，欢迎交流讨论！**
