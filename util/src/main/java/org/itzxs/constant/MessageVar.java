package org.itzxs.constant;

import org.itzxs.util.PropertiesUtil;

/**
 * 系统消息变量
 * Created by Itzxs on 2018/5/30.
 */
public class MessageVar {
    private static String getMsg(String key) {
        return PropertiesUtil.getMessage(key);
    }

    /**
     * 用户名或密码错误
     */
    public static final String LOGIN_USER_PWD_ERROR = getMsg("login.user.pwd.error");

    /**
     * 密码不能为空
     */
    public static final String PASS_WORD_NOT_EMPTY = getMsg("password.not.empty");

    /**
     * 注册失败
     */
    public static final String REGISTER_ERROR = getMsg("rigister.error");
}
