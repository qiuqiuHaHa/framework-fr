package com.dev.framework.core.json;

import java.lang.reflect.Type;

/**
 * @Author fanr
 * @Date 2017/9/30 16:03
 * @desc
 */
public interface FrameworkJsonService {
    String toJson(Object src);
    <T> T fromJson(String json, Class<T> cls);
    <T> T fromJson(String json, Type type);
}
