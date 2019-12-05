package com.thoughtworks.exception;

/**
 * @program: galaxy
 * @description: 自定义异常类
 * @author: ffye
 * @create: 2019-12-05 14:01
 */
public class GalaxyException extends RuntimeException {
    public GalaxyException() {
    }

    public GalaxyException(String message) {
        super(message);
    }

    public GalaxyException(String message, Throwable cause) {
        super(message, cause);
    }

    public GalaxyException(Throwable cause) {
        super(cause);
    }

    public GalaxyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
