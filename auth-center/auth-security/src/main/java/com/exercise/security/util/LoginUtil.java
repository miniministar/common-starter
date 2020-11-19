package com.exercise.security.util;


import com.exercise.security.manager.AsyncFactory;
import com.exercise.security.manager.AsyncManager;
import com.exercise.common.core.constant.Constants;

public class LoginUtil {
    public static void failLog(String username, String message) {
        //登陆日志
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, message));
    }

}
