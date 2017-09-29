package com.dev.framework.core.authenticate;

import com.dev.framework.core.session.FrameworkSession;
import org.apache.shiro.subject.Subject;

/**
 * @Author fanr
 * @Date 2017/9/29 16:15
 * @desc
 */
public interface LogonCallback {

    void callback(FrameworkSession session, Subject subject);

}
