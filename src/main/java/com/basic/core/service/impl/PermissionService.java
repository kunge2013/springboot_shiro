package com.basic.core.service.impl;

import com.basic.core.jpa.dao.PermissionJPA;
import com.basic.core.jpa.bean.UserPermissionView;
import com.basic.core.service.IJdbcQueryService;
import com.basic.core.service.IPermissionService;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PermissionJPA permissionJPA;

    @Autowired
    private IJdbcQueryService jdbcQueryService;

    @Override
    public List<UserPermissionView> getUserPermission(String username) {
        List<UserPermissionView> list1 = jdbcQueryService.queryForList("SELECT u.id as userId,u.nickname as nickname,u.role_id as roleId,r.role_name as roleName,p.menu_code as menuCode,p.permission_code as permissionCode FROM sys_user u LEFT JOIN sys_role r ON r.id = u.role_id LEFT JOIN sys_role_permission rp ON u.role_id = rp.role_id LEFT JOIN sys_permission p ON rp.permission_id = p.id AND rp.delete_status = 1 WHERE  u.delete_status = 1  ",
                UserPermissionView.class, new Object[] {});

        List<UserPermissionView> list = jdbcTemplate.query("SELECT u.id as userId,u.nickname as nickname,u.role_id as roleId,r.role_name as roleName,p.menu_code as menuCode,p.permission_code as permissionCode FROM sys_user u LEFT JOIN sys_role r ON r.id = u.role_id LEFT JOIN sys_role_permission rp ON u.role_id = rp.role_id LEFT JOIN sys_permission p ON rp.permission_id = p.id AND rp.delete_status = 1 WHERE  u.delete_status = 1" +
                        "    AND u.username= '" + username +"'",
                (rs, b) -> {
                    UserPermissionView userPermissionView = new UserPermissionView();
                    userPermissionView.setMenuCode(rs.getString("menuCode"));
                    userPermissionView.setNickname(rs.getString("nickname"));
                    userPermissionView.setRoleId(rs.getLong("roleId"));
                    userPermissionView.setUserId(rs.getLong("userId"));
                    userPermissionView.setPermissionCode(rs.getString("permissionCode"));
                    return userPermissionView;
                } );
        return list;
    }
}
