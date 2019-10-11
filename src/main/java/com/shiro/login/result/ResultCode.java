package com.shiro.login.result;

public enum ResultCode {
    /** 成功 */
    SUCCESS("200", "成功"),

    /**查询服务种类成功*/
    QUERY_SERVICE_TYPE_SUCCESS("201","查询服务种类成功"),

    /**查询服务区域成功*/
    QUERY_SERVICE_AREA_SUCCESS("202","查询服务区域成功"),

    /** 没有登录 */
    NOT_LOGIN("400", "没有登录"),

    /** 发生异常 */
    EXCEPTION("401", "发生异常"),

    /** 系统错误 */
    SYS_ERROR("402", "系统错误"),

    /** 参数错误 */
    PARAMS_ERROR("403", "参数错误 "),

    /** 不支持或已经废弃 */
    NOT_SUPPORTED("404", "不支持或已经废弃"),

    /**手机号码不正确*/
    NOT_MOBILE_NUM("405","请输入正确的手机号码"),

    /**密码不正确*/
    INCURRECT_PASSWORD("406","输入密码不正确"),

    /**手机号码不正确*/
    INCURRECT_MOBILE_PHONE_NUM("407","登录的手机号码不正确"),

    /** AuthCode错误 */
    INVALID_AUTHCODE("408", "无效的AuthCode"),

    /** 太频繁的调用 */
    TOO_FREQUENT("409", "太频繁的调用"),

    /**没有数据*/
    NO_DATA("410","没有数据"),


    /** 未知的错误 */
    UNKNOWN_ERROR("499", "未知错误");

    ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
