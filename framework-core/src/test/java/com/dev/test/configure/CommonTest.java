package com.dev.test.configure;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author fanr
 * @Date 2017/9/28 11:21
 * @desc
 */
public class CommonTest {

    public static void main(String[] args) {

        Object otherCode = null;
        String e = (String)otherCode;
        System.out.println("otherCode = [" + e  + "]");
        //System.out.println("otherCode = [" + otherCode.toString() + "]");

//        String regex = pattern.replaceAll("\\*", "\\.\\*");
//        map.keySet().stream()
//                .filter((n) -> n.matches(regex))
//                .forEach((t)->map.remove(t));

        String pattern = "a*a";
        System.out.println("args = [" + pattern.replaceAll("\\*", "\\.\\*") + "]");
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("aba.*ac", "111");
        map.put("bba.*ab", "222");
        map.put("ccc", "333");
        map.put("dda.*ad", "444");
        map.put("lele", "eee");

        map.keySet().stream().forEach((n) -> System.out.println(n + ":" + map.get(n)));
        System.out.println("=====================");
                String regex = pattern.replaceAll("\\*", "\\.\\*");
        map.keySet().stream()
                .filter((n) -> n.contains("a"))
                .forEach((t)->map.remove(t));
        System.out.println("=====================");
        map.keySet().stream().forEach((n) -> System.out.println(n + ":" + map.get(n)));
    }

}
