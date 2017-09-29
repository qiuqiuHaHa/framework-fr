package com.dev.framework.core.authenticate;

import com.dev.framework.core.session.FrameworkSession;

import java.util.Map;

/**
 * @Author fanr
 * @Date 2017/9/26 17:16
 * @desc
 */
public interface FrameworkLogonService {

    /**
     * login
     * @param username 用户名
     * @param password 密码
     * @param type  登录类型
     * @param host  host账号
     * @param ip    ip地址
     * @param params    参数
     * @param capchacode    验证码
     * @return
     */
    FrameworkSession login(String username,
                           String password,
                           String type,
                           String host,
                           String ip,
                           Map<String, String> params,
                           String captchaCode);


}
