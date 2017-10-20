package com.dev.framework.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author fanr
 * @Date 2017/9/30 14:20
 * @desc
 */
@Component
public class FrameworkApplicationUtils {

    @Autowired
    private ApplicationContext _content;

    private static ApplicationContext context;

    @PostConstruct
    public void initializer(){
        context = _content;
    }

    public static <T> T getBean(Class<T> cls){
        return context.getBean(cls);
    }

    public static <T> T getBean(String beanId){
        return (T)context.getBean(beanId);
    }

}
