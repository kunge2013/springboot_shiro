package com.basic.core.jpa.dao;

import com.basic.core.jpa.bean.UserInfo;
import com.basic.core.jpa.vo.UserPermissionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用戶登陸
 */
@Transactional
public interface PermissionJPA
        extends JpaRepository<UserInfo, Long>
{
    @Query(value = "SELECT u.id as userId,u.nickname as nickname,u.role_id as roleId,r.role_name as roleName,p.menu_code as menuCode,p.permission_code as permissionCode FROM sys_user u LEFT JOIN sys_role r ON r.id = u.role_id LEFT JOIN sys_role_permission rp ON u.role_id = rp.role_id LEFT JOIN sys_permission p ON rp.permission_id = p.id AND rp.delete_status = 1 WHERE  u.delete_status = 1 AND u.id= ?1",
                nativeQuery = true)
    List<UserPermissionView> getUserPermission(String userName);
}
