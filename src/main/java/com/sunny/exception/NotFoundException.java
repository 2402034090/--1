package com.sunny.exception;

/**
 * 用户自定义运行时异常
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
