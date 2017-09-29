package com.dev.framework.core.session;

/**
 * @Author fanr
 * @Date 2017/9/26 16:45
 * @desc
 */
public interface FrameworkSession {

    /**
     * 获得session中的attribute
     * @param object
     * @return
     */
    Object getAttribute(Object object);

    /**
     * 设置session的attribute
     * @param key
     * @param value
     */
    void setAttribute(Object key, Object value);

    /**
     * 移除key
     * @param key
     */
    void removeAttribute(Object key);

    /**
     * 删除会话
     */
    void remove();

}
