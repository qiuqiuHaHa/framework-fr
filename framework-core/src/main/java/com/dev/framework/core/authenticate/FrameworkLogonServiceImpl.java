package com.dev.framework.core.authenticate;

import com.dev.framework.core.configure.SystemConfigProperties;
import com.dev.framework.core.execption.ErrorCodeException;
import com.dev.framework.core.session.CurrentSessionStoreFactory;
import com.dev.framework.core.session.FrameworkSession;
import com.dev.framework.core.shiro.RuntimeAuthenticationException;
import com.dev.framework.core.shiro.ServiceAuthenticationException;
import com.dev.framework.core.util.Constants;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import scala.collection.immutable.Stream;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author fanr
 * @Date 2017/9/26 17:16
 * @desc
 */
@Service
public class FrameworkLogonServiceImpl implements FrameworkLogonService {

    private static final Logger logger = LoggerFactory.getLogger(FrameworkLogonServiceImpl.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private FrameworkRealmFactory frameworkRealmFactory = null;

    @Override
    public FrameworkSession login(String username,
                                  String password,
                                  String type,
                                  String host,
                                  String ip,
                                  Map<String, String> params,
                                  String captchaCode) {

        if (Boolean.valueOf(SystemConfigProperties.getProperty(Constants.CAPTCHA_SERVICE_ISREQUIRED, "false"))) {

            FrameworkSession session = CurrentSessionStoreFactory.getCurrentSessionStore().getCurrentSession();
            if (captchaCode == null
                    || session == null
                    || captchaCode.equalsIgnoreCase((String) session.getAttribute(Constants.CAPTCHA_CODE))) {

                logger.info("验证码不正确");
                throw new ErrorCodeException(6, "验证码不正确");

            } else {
                session.removeAttribute(Constants.CAPTCHA_CODE);
                session.remove();
            }

        }

//        Subject subject = new Subject.Builder().authenticated(false).buildSubject();
//        if(subject.getSession(false) != null){
//            subject.logout();
//        }
//        FrameworkUserPasswordToken token = new FrameworkUserPasswordToken(username, password, type, host);
//        token.setIp(ip);

        Subject subject = new Subject.Builder().authenticated(false).buildSubject();
        if (subject.getSession(false) != null) {
            subject.logout();
        }

        FrameworkUserPasswordToken token = new FrameworkUserPasswordToken(username, password, host, type);
        token.setIp(ip);

        if (params != null) {
            token.setParams(params);
        }

        try {
            subject.login(token);
        } catch (IncorrectCredentialsException | UnknownAccountException e) {
            logger.info("用户名或密码错误");
            throw new ErrorCodeException(1, "用户名或密码错误", e);
        } catch (LockedAccountException e) {
            logger.info("账户锁定", e);
            throw new ErrorCodeException(2, "账户锁定", e);
        } catch (ConcurrentAccessException e) {
            logger.info("用户已在别处登录", e);
            throw new ErrorCodeException(3, "用户已在别处登录", e);
        } catch (ExcessiveAttemptsException e) {
            logger.info("输入错误次数超过系统允许最大次数", e);
            throw new ErrorCodeException(4, "输入错误次数超过系统允许最大次数", e);
        } catch (ExpiredCredentialsException e) {
            logger.info("密码已过期", e);
            throw new ErrorCodeException(5, "密码已过期", e);
        } catch (RuntimeAuthenticationException e) {
            throw e;
        } catch (ServiceAuthenticationException e){
            logger.error("登录发生业务异常：" + e);
            throw new ErrorCodeException(e.getErrorCode(), e.getErrorMsg());
        } catch (AuthenticationException e) {
            logger.info("用户名或密码错误");
            throw new ErrorCodeException(1, "用户名或密码错误", e);
        } catch (Exception e){
            logger.error("登录发送未知异常：", e);
            throw new ErrorCodeException(100, "其他错误", e);
        }

        setPermissionCache(subject);



        return null;
    }

    /**
     * 缓存权限
     * @param subject
     */
    private void setPermissionCache(Subject subject){

        Session session = subject.getSession();
        session.removeAttribute(Constants.SESSION_PERMISSION);
        Set<String> permissions = new HashSet<String>();
        subject.hasRole("");

        AuthorizingRealm realm = (AuthorizingRealm) frameworkRealmFactory.getRealm();
        Cache<Object, AuthorizationInfo> cache =  realm.getAuthorizationCache();
        for(AuthorizationInfo authorizationInfo : cache.values()){
            permissions.addAll(authorizationInfo.getStringPermissions());
        }

        session.setAttribute(Constants.SESSION_PERMISSION, permissions);
        cache.clear();

    }

}
