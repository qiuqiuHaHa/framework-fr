package com.dev.framework.core.execption;

/**
 * @Author fanr
 * @Date 2017/9/28 11:31
 * @desc
 */
public class ErrorCodeException extends RuntimeException{


    private static final long serialVersionUID = 1;

    private int errorCode;

    private String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorCodeException(int errorCode, String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCodeException(int errorCode, String errorMessage, Exception e){
        super(e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return "验证码错误:" + errorCode + ",错误描述:" + errorMessage;
    }

}
