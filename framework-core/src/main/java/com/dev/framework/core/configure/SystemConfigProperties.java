package com.dev.framework.core.configure;

import com.dev.framework.core.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * @Author fanr
 * @Date 2017/9/26 17:30
 * @desc
 */
@Component
public class SystemConfigProperties {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(SystemConfigProperties.class);

    /**
     * 配置项
     */
    private static final Properties properties = new Properties();

    /**
     * 样式类型
     */
    private static final Pattern pattern = Pattern.compile("\\$\\{([^\\}]+)\\}");

    static{
        synchronized (properties){
            try {
                properties.load(new InputStreamReader(
                        SystemConfigProperties.class.getClassLoader().getResourceAsStream(Constants.SYS_CONFIG_FILE),
                        "UTF-8"));
            }catch (UnsupportedEncodingException e){
                logger.info("读取配置文件：" + Constants.SYS_CONFIG_FILE + " 失败");
                throw new RuntimeException("读取配置文件：" + Constants.SYS_CONFIG_FILE + " 失败");
            }catch (IOException e){
                logger.info("读取配置文件：" + Constants.SYS_CONFIG_FILE + " 失败");
                throw new RuntimeException("读取配置文件: " + Constants.SYS_CONFIG_FILE + " 失败");
            }
        }
    }

    //public static


}
