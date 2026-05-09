package com.example.springbootlearning.model;

/**
 * 用户模型类
 * 使用 Lombok 注解简化代码：
 * - @Data: 自动生成 getter/setter/toString/equals/hashCode
 * - @NoArgsConstructor: 生成无参构造器
 * - @AllArgsConstructor: 生成全参构造器
 */
public class User {
    private Long id;
    private String name;
    private String email;
    private Integer age;

    public User() {
    }

    public User(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getter 和 Setter 方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
