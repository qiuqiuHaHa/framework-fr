package com.dev.framework.core.configure;

import com.dev.framework.core.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author fanr
 * @Date 2017/9/28 10:34
 * @desc
 */
public class SystemConfigProperties {

    public static final Logger LOGGER = LoggerFactory.getLogger(SystemConfigProperties.class);

    public static Pattern pattern = Pattern.compile("\\$\\{([^\\}]+)\\}");

    public static Properties properties = new Properties();

    static{

        try {
            properties.load(new InputStreamReader(
                    SystemConfigProperties.class.getClassLoader()
                            .getResourceAsStream(Constants.SYS_CONFIG_FILE)));
        } catch (IOException e) {
            LOGGER.info("初始化文件失败，初始化文件为：" + Constants.SYS_CONFIG_FILE);
        }


    }

    public static String getProperty(String key){
        return getProperty(key, null);
    }

    public static String getProperty(String key, String defaultValue){

        String result = getPatternProperties(key);
        if(result == null || StringUtils.isEmpty(result)){
            return defaultValue;
        }else{
            return result;
        }

    }

    /**
     * 支持${}引用替换
     * @param key
     * @return
     */
    public static String getPatternProperties(String key){

        String propertyKey = properties.getProperty(key);

        Matcher matcher = pattern.matcher(propertyKey);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()){

            String matcherKey = matcher.group(1);
            String matcherValue = properties.getProperty(matcherKey);
            if(matcherValue != null){
                matcher.appendReplacement(stringBuffer, matcherValue);
            }

        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();

    }

    public static void setProperty(String key, String value){
        properties.setProperty(key, value);
    }


}
