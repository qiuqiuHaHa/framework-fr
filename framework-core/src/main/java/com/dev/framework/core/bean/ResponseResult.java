package com.dev.framework.core.bean;

import scala.Int;

import java.io.Serializable;

/**
 * @Author fanr
 * @Date 2017/9/30 13:10
 * @desc
 */
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -9214543762943400780L;
    /**
     * 版本
     */
    protected final String version = "1.0";

    /**
     * 错误消息
     */
    protected String errorMsg = null;

    /**
     * 错误码
     */
    protected Integer errorCode = 0;

    /**
     * 获取结果的json串
     */
    protected Object data = null;

    public String getVersion() {
        return version;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
