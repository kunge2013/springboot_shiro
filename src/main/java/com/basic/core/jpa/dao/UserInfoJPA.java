package com.basic.core.jpa.dao;

import com.basic.core.jpa.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用戶登陸
 */
@Transactional
public interface UserInfoJPA
        extends JpaRepository<UserInfo, Long>
{
    List<UserInfo> findUserInfo(String userName, String passWord);

}
