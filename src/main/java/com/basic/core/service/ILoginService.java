package com.basic.core.service;

import com.basic.core.jpa.bean.UserInfo;

public interface ILoginService {
    /**
     * 用戶登录认证
     * @param userName 名称
     * @param passWord 密码
     * @return true 成功 false 失败
     */
     boolean authLogin(String userName, String passWord);

     UserInfo getUser(String username, String password) throws Exception;


     Object getInfo();

}
