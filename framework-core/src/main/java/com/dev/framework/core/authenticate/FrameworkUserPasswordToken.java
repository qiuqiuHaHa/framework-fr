package com.dev.framework.core.authenticate;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fanr
 * @Date 2017/9/29 10:02
 * @desc
 */
public class FrameworkUserPasswordToken extends UsernamePasswordToken{


    private static final long serialVersionUID = 1L;

    private String type;

    private String ip = null;

    Map<String, String> params = new HashMap<String, String>();

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public FrameworkUserPasswordToken(String username, char[] password) {
        super(username, password);
    }

    public FrameworkUserPasswordToken(String username, String password) {
        super(username, password);
    }

    public FrameworkUserPasswordToken(String username, char[] password, String host) {
        super(username, password, host);
    }

    public FrameworkUserPasswordToken(String username, String password, String host, String type) {
        super(username, password, host);
        this.type = type;
    }

    public FrameworkUserPasswordToken(String username, char[] password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public FrameworkUserPasswordToken(String username, String password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public FrameworkUserPasswordToken(String username, char[] password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }

    public FrameworkUserPasswordToken(String username, String password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }
}
