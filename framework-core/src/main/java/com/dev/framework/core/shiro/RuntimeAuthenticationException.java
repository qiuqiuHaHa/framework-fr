package com.dev.framework.core.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Author fanr
 * @Date 2017/9/29 11:41
 * @desc
 */
public class RuntimeAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 2134216916174259049L;

    public RuntimeAuthenticationException() {
        super();
    }

    public RuntimeAuthenticationException(String message) {
        super(message);
    }

    public RuntimeAuthenticationException(Throwable cause) {
        super(cause);
    }

    public RuntimeAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
