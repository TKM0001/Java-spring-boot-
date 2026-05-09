package com.example.springbootlearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Spring Boot 应用程序测试类
 * 
 * @SpringBootTest: 启动完整的 Spring Boot 应用上下文进行测试
 * 
 * 测试类型说明：
 * 1. 单元测试（Unit Test）：测试单个方法或类
 * 2. 集成测试（Integration Test）：测试多个组件协同工作
 * 3. 端到端测试（E2E Test）：模拟真实用户操作流程
 */
@SpringBootTest
class SpringBootLearningApplicationTests {

    /**
     * 测试应用上下文是否正常加载
     */
    @Test
    void contextLoads() {
        // 如果这个测试通过，说明 Spring Boot 应用能够正常启动
        assertThat(true).isTrue();
    }
}
