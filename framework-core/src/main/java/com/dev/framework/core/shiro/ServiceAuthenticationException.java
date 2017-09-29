package com.dev.framework.core.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Author fanr
 * @Date 2017/9/29 11:53
 * @desc
 */
public class ServiceAuthenticationException extends AuthenticationException{

    private static final long serialVersionUID = -7530274051499329424L;

    private int errorCode;

    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ServiceAuthenticationException(int errorCode, String errorMsg) {
        super("错误码：" + errorCode + ",错误描述：" + errorMsg);
        if(errorCode <= 0){
            throw new RuntimeException("error code cannot be less than zero");
        }
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ServiceAuthenticationException(int errorCode, String errorMsg, Exception e){
        super("错误码：" + errorCode + ",错误描述：" + errorMsg, e);
        if(errorCode <= 0 ){
            throw new RuntimeException("error code cannot be less than zero");
        }
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
