package com.dev.framework.core.authenticate;

import com.dev.framework.core.configure.SystemConfigProperties;
import com.dev.framework.core.session.CurrentSessionStoreFactory;
import com.dev.framework.core.session.FrameworkSession;
import com.dev.framework.core.util.Constants;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author fanr
 * @Date 2017/9/29 16:48
 * @desc
 */
@Service
public class FrameworkLogoutServiceImpl implements FrameworkLogoutService {

    private static final Logger logger = LoggerFactory.getLogger(FrameworkLogoutServiceImpl.class);

    @Autowired
    private ApplicationContext context;

    /**
     * 登出   用户的唯一标识符
     * @param sessionId
     */
    @Override
    public void logout(String sessionId) {
        if(sessionId != null){
            try{

                FrameworkSession frameworkSession
                        = CurrentSessionStoreFactory.getCurrentSessionStore().getCurrentSession();
                String callbackNames = SystemConfigProperties.getProperty(Constants.LOGOUT_CALL_BACKS);
                if(callbackNames != null){
                    String[] callbackArrays = callbackNames.split(Constants.COMMA);
                    for(String s : callbackArrays){
                        if(s!=null && !Constants.EMPTY_STRING.equals(s.trim())){
                            LogoutCallback logoutCallback = (LogoutCallback)context.getBean(s);
                            logoutCallback.callback(frameworkSession);
                        }
                    }

                }

                Subject subject = new Subject.Builder().sessionId(sessionId).buildSubject();
                subject.logout();

            }catch (Exception e){
                logger.info("session无效或者过期", e);
            }
        }
    }

}
