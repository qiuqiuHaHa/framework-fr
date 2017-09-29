package com.dev.framework.core.authenticate;

import com.dev.framework.core.configure.SystemConfigProperties;
import com.dev.framework.core.util.Constants;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author fanr
 * @Date 2017/9/29 15:05
 * @desc
 */
@Service
public class FrameworkRealmFactory {

    private final static Logger logger = LoggerFactory.getLogger(FrameworkRealmFactory.class);

    @Autowired
    private ApplicationContext context;

    public Realm getRealm(){

        try {
            return (Realm)context.getBean(SystemConfigProperties.getProperty(Constants.REALM_BEAN_NAME,null));
        } catch (BeansException e) {
            logger.info("shiro load realm error. use the default realm");
        }

        return context.getBean(FrameworkDefaultRealm.class);

    }

}
