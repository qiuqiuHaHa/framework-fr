package com.dev.framework.core.cache;

import com.dev.framework.core.json.FrameworkJsonSerializer;
import com.dev.framework.core.util.FrameworkApplicationUtils;

/**
 * @Author fanr
 * @Date 2017/9/30 13:57
 * @desc
 */
public class CacheUtils {

    private static FrameworkJsonSerializer jsonSerializer;
    public static FrameworkJsonSerializer getJsonSerializer(){

        if(jsonSerializer == null){
            jsonSerializer = FrameworkApplicationUtils.getBean(FrameworkJsonSerializer.class);
        }

        return jsonSerializer;

    }

    /**
     * 将对象编码为字符串
     * @param obj
     * @return
     */
    public static String encodeToString(Object obj){
        return getJsonSerializer().serialize(obj);
    }

    /**
     * 将字符串反编码成对象
     * @param str
     * @return
     */
    public static Object decodeToObject(String str){
        if(str == null){
            return null;
        }
        return getJsonSerializer().deserialize(str);
    }

    /**
     *
     * @param obj
     * @return
     */
    public static String getKeyByObj(Object obj){
        String keystr = null;
        if(obj instanceof String){
            keystr = (String)obj;
        }else{
            keystr = encodeToString(obj);
        }
        return keystr;
    }

}
