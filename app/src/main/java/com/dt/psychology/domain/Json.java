package com.dt.psychology.domain;

/**
 * Created by dnnt9 on 2017/4/4.
 */

public class Json<T> {
    private String message;
    private boolean successful;
    private T object;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
