package org.itzxs.exception;

/**
 * Created by Itzxs on 2018/5/29.
 */
public enum ServiceExceptionEnum implements ExceptionEnum {

    USERNAME_EXIST(100001, ""),
    READ_CONFIG_ERROR(100002,"读取配置文件出错"),
    DELETE_FAIL(100003,"删除失败"),

    UPLOAD_NOT_IMAGE(100100,"上传的文件不是图片");
    public int code;
    public String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public int getCode() {
       return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
