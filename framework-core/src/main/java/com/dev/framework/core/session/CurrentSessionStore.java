package com.dev.framework.core.session;

/**
 * @Author fanr
 * @Date 2017/9/26 16:43
 * @desc
 */
public interface CurrentSessionStore {

    void removeCurrentSession();

    FrameworkSession getCurrentSession();

    void setCurrentSession(FrameworkSession frameworkSession);

}
