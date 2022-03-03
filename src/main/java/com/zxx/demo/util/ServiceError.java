package com.zxx.demo.util;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  13:57
 */
public enum ServiceError {

    //业务层调用错误码
    SERVICE_OK(0, "操作成功"),
    SERVICE_UNKNOWN_ERROR(1, "未知异常"),
    SERVICE_NETWORK_ERROR(2, "网络异常"),
    SERVICE_DBDAO_ERROR(3, "返回数据库的具体异常信息"),
    SERVICE_SPEAKER_NOT_EXISTED(4, "数据库中没有要查询的记录"),
    SERVICE_INVALID_PARAMETER(5, "方法参数错误"),
    SERVICE_FUNCTION_NO_ACCESS(6, "对此方法无访问权限")


    ;

    private String msg;
    private int code;

    private ServiceError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }
}
