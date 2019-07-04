package com.basic.core.service;

import com.basic.core.jpa.bean.UserPermissionView;

import java.util.List;

public interface IPermissionService {
    /**
     * 查询某用户的 角色  菜单列表   权限列表
     */
    List<UserPermissionView> getUserPermission(String username);
}
