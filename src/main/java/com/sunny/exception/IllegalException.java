package com.sunny.exception;

/**
 * Created by zc on 2018/4/11.
 */
public class IllegalException extends RuntimeException {
    public IllegalException() {
        super();
    }

    public IllegalException(String message) {
        super(message);
    }
}
