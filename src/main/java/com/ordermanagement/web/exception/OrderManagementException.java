package com.ordermanagement.web.exception;

public class OrderManagementException extends Exception{
    public OrderManagementException() {
        super();
    }

    public OrderManagementException(String message) {
        super(message);
    }

    public OrderManagementException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderManagementException(Throwable cause) {
        super(cause);
    }

    protected OrderManagementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
