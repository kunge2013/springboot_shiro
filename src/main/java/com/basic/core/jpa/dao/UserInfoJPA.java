package com.basic.core.jpa.dao;

import com.basic.core.jpa.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用戶登陸
 */
@Transactional
public interface UserInfoJPA
        extends JpaRepository<UserInfo, Long>
{
    @Query("select t from UserInfo t where t.userName =?1 and t.passWord=?2")
    List<UserInfo> findUserInfo(String userName, String passWord);
}
