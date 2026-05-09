package com.example.springbootlearning.exception;

/**
 * 自定义业务异常类
 * 用于处理业务逻辑中的特定错误情况
 */
public class BusinessException extends RuntimeException {
    
    private int code;

    public BusinessException(String message) {
        super(message);
        this.code = 400;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
