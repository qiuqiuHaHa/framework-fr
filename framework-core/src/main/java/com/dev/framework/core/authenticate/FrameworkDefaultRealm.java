package com.dev.framework.core.authenticate;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author fanr
 * @Date 2017/9/29 15:13
 * @desc
 */
@Service("frameworkDefaultRealm")
public class FrameworkDefaultRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo
            (PrincipalCollection principalCollection) {

        //所有权限
        Set<String> permission = new TreeSet<String>();
        Set<String> role = new TreeSet<String>();
        role.add("Guest");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(role);
        info.setStringPermissions(permission);

        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo
            (AuthenticationToken authenticationToken)
            throws AuthenticationException {
        return new SimpleAuthenticationInfo("Guest", "Guest", "DefaultRealm");
    }

}
