package com.dt.psychology.util;

/**
 * Created by dnnt9 on 2017/4/8.
 */

public class NetworkUnavailableException extends Exception {
    public NetworkUnavailableException() {
        this("当前网络不可用");
    }
    public NetworkUnavailableException(String message) {
        super(message);
    }
}
