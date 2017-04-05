package com.dt.psychology.util;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public class Validator {

    public static boolean isMobile(String phone){
        return phone.matches("^((17[0-9])|(13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
    }

    public static boolean isEmail(String email){
        return email.matches("^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
//        "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
    }

    public static boolean isNickname(String nickname){
        return nickname.matches("^\\S{4,16}$");
    }

    public static boolean isPassword(String password){
        return password.matches("^.{6,16}$");
    }

    public static boolean isVerificationCode(String code){
        return code.matches("^\\d{6}$");
    }
}
