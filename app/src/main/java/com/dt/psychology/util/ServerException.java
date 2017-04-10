package com.dt.psychology.util;

/**
 * Created by dnnt9 on 2017/4/8.
 */

public class ServerException extends Exception {
    public ServerException() {
        this("服务器出错");
    }

    public ServerException(String message) {
        super(message);
    }
}
