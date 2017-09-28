package com.dev.test.configure;

import com.dev.framework.core.configure.SystemConfigProperties;

/**
 * @Author fanr
 * @Date 2017/9/28 10:00
 * @desc
 */
public class SystemConfigTest {

    public static void main(String[] args) {
        String value = SystemConfigProperties.getProperty("bb");
        System.out.println("value = [" + value + "]");
    }

}
