package com.dev.framework.core.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Author fanr
 * @Date 2017/9/26 16:46
 * @desc
 */
public class FrameworkSessionImpl implements FrameworkSession {

    /**
     * shiro session
     */
    private Session session;

    /**
     * shiro subject
     */
    private Subject subject;

    /**
     * 用户名
     */
    private String userName;

    public FrameworkSessionImpl(Session session, Subject subject, String userName) {
        super();
        this.session = session;
        this.subject = subject;
        this.userName = userName;
    }

    @Override
    public Object getAttribute(Object object) {
        return null;
    }

    @Override
    public void setAttribute(Object key, Object value) {

    }

    @Override
    public void removeAttribute(Object key) {

    }

    @Override
    public void remove() {

    }
}
