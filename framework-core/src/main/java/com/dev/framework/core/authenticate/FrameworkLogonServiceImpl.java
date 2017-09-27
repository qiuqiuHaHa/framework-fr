package com.dev.framework.core.authenticate;

import com.dev.framework.core.session.FrameworkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

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


    @Override
    public FrameworkSession login(String username, String password, String type, String host, String ip, Map<String, String> params, String capchacode) {



        return null;
    }
}
