package com.dev.framework.core.json;

import org.springframework.stereotype.Component;

/**
 * @Author fanr
 * @Date 2017/9/30 14:08
 * @desc
 */
@Component
public class FrameworkJsonSerializer {

    private static String CONTEXT_AUTHENTICATED_SESSION_KEY = "org.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEY";
    private static String CONTEXT_PRINCIPALS_SESSION_KEY = "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY";
    private static String CONTEXT_USERID_KEY = "userId";

    public String serialize(Object obj){
        return null;
    }

    public Object deserialize(String jsonStr){
        return null;
    }



}
