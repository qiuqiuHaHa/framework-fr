package com.dev.framework.core.session;

/**
 * @Author fanr
 * @Date 2017/9/26 16:43
 * @desc
 */
public class ThreadLocalSessionStore implements CurrentSessionStore {

    private static ThreadLocal<FrameworkSession> threadLocal = new ThreadLocal<FrameworkSession>();

    @Override
    public void removeCurrentSession() {
        threadLocal.remove();
    }

    @Override
    public FrameworkSession getCurrentSession() {
        return threadLocal.get();
    }

    @Override
    public void setCurrentSession(FrameworkSession frameworkSession) {
        if(frameworkSession == null){
            return;
        }
        threadLocal.set(frameworkSession);
    }
}
