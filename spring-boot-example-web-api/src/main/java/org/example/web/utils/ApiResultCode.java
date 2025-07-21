package org.example.web.utils;

public enum ApiResultCode {
    /**
     * code: 首位数字代表操作成功(1)与失败(2),第2~4位代表模块,第5~6位代表功能,第7位为代表具体功能的状态
     * */
    /**
     * 操作成功
     * */
    SUCCESS(ApiResultStatus.SUCCESS, "1000000", "操作成功!"),
    /**
     * 操作失败
     * */
    ERROR( ApiResultStatus.ERROR, "2000000", "操作失败!"),

    /**
     * 您还没有登录,请先登录
     * */
    ERR_NOT_LOGIN( ApiResultStatus.ERROR, "2000001", "您还没有登录,请先登录!"),

    /**
     * 查询成功
     * */
    SUC_FIND( ApiResultStatus.SUCCESS, "1001011", "查询成功!"),
    /**
     * 查询失败
     * */
    ERR_FIND( ApiResultStatus.ERROR, "2001012", "查询失败!"),
    /**
     * 保存成功
     * */
    SUC_SAVE( ApiResultStatus.SUCCESS, "1001021", "保存成功!"),
    /**
     * 保存失败
     * */
    ERR_SAVE( ApiResultStatus.ERROR, "2001022", "保存失败!"),
    /**
     * 修改成功
     * */
    SUC_UPDATE( ApiResultStatus.SUCCESS, "1001031", "修改成功!"),
    /**
     * 修改失败
     * */
    ERR_UPDATE( ApiResultStatus.ERROR, "2001032", "修改失败!"),
    /**
     * 删除成功
     * */
    SUC_DELETE( ApiResultStatus.SUCCESS, "1001041", "删除成功!"),
    /**
     * 删除失败
     * */
    ERR_DELETE( ApiResultStatus.ERROR, "2001042", "删除失败!"),

    /**
     * 登录成功
     * */
    SUC_LOGIN( ApiResultStatus.SUCCESS, "1002011", "登录成功!"),
    /**
     * 登录失败
     * */
    ERR_LOGIN( ApiResultStatus.ERROR, "2002012", "登录失败!"),
    /**
     * 用户名或密码不能为空
     * */
    ERR_LOGIN_ACC_PWD_NOT_NULL( ApiResultStatus.ERROR, "2002013", "用户名或密码不能为空!"),
    /**
     * 用户名或密码错误
     * */
    ERR_LOGIN_ACC_PWD_WRONG( ApiResultStatus.ERROR, "2002014", "用户名或密码错误!"),

    /**
     * 退出成功
     * */
    SUC_LOGOUT( ApiResultStatus.SUCCESS, "1002021", "退出成功!"),
    /**
     * 退出失败
     * */
    ERR_LOGOUT( ApiResultStatus.ERROR, "2002022", "退出失败!"),
    /**
     * 注册成功
     * */
    SUC_REGISTER( ApiResultStatus.SUCCESS, "1002031", "注册成功!"),
    /**
     * 注册失败
     * */
    ERR_REGISTER( ApiResultStatus.ERROR, "2002032", "注册失败!"),
    /**
     * 用户名不能为空
     * */
    ERR_REGISTER_ACC_NOT_NULL( ApiResultStatus.ERROR, "2002033", "用户名不能为空!"),
    /**
     * 密码不能为空
     * */
    ERR_REGISTER_PWD_NOT_NULL( ApiResultStatus.ERROR, "2002034", "密码不能为空!"),
    /**
     * 两次输入密码不一致
     * */
    ERR_REGISTER_PWDS_DIFFERENT( ApiResultStatus.ERROR, "2002035", "两次输入密码不一致!"),
    /**
     * 用户名已存在
     * */
    ERR_REGISTER_ACC_EXISTS( ApiResultStatus.ERROR, "2002036", "用户名已存在!"),



    ;

    private ApiResultStatus resultStatus;
    private String code;
    private String msg;

    public ApiResultStatus getResultStatus() {
        return resultStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ApiResultCode(ApiResultStatus resultStatus, String code, String msg){
        this.resultStatus = resultStatus;
        this.code = code;
        this.msg = msg;
    }
}
