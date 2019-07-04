package com.basic.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.basic.core.jpa.bean.SysPermission;
import com.basic.core.jpa.bean.UserInfo;
import com.basic.core.jpa.dao.UserInfoJPA;
import com.basic.core.jpa.vo.UserPermissionView;
import com.basic.core.service.ILoginService;
import com.basic.core.service.IPermissionService;
import com.basic.core.shiro.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private UserInfoJPA userInfoJPA;
    @Autowired
    private IPermissionService permissionService;
    @Override
    public boolean authLogin(String userName, String passWord) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public UserInfo getUser(String username, String password) throws Exception{
       List<UserInfo> list =  userInfoJPA.findUserInfo(username, password);
       if (null != list) {
           return list.get(0);
       }
        throw new Exception("auth error");
    }

    @Override
    public Object getInfo() {
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute(Constants.SESSION_USER_INFO);
        String username = userInfo.getUserName();
        JSONObject info = new JSONObject();
        List<UserPermissionView> userPermission = permissionService.getUserPermission(username);
        /**
         * 添加泉下信息到
         */
        {

        }
        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
        info.put("userPermission", userPermission);
        return info;
    }
}
