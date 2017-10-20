package com.dev.framework.core.local;

import com.dev.framework.core.configure.SystemConfigProperties;
import com.dev.framework.core.util.Constants;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @Author fanr
 * @Date 2017/9/30 17:09
 * @desc
 */
public class LocalCacheService {

    private static final Map<String, Object> map = new ConcurrentHashMap<String, Object>();

    private static Integer expire = Integer.parseInt(SystemConfigProperties.getProperty(Constants.CACHE_EXPIRE,"1800"));

    private static Object getKey(String key){
        return map.get(key);
    }

    private static void put(String key, Object obj){
        put(key, obj, expire);
    }

    private static void put(String key, Object obj, Integer seconds){
        map.put(key, obj);
    }

    private static void del(String key){
        map.remove(key);
    }

    public static void delAll(){
        map.clear();
    }

    public static void delByPattern(String pattern){
        String regex = pattern.replaceAll("\\*", "\\.\\*");
        map.keySet().stream()
                .filter((n) -> n.matches(regex))
                .forEach((t)->map.remove(t));
    }

}
