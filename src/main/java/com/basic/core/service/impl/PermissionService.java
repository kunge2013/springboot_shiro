package com.basic.core.service.impl;

import com.basic.core.jpa.dao.PermissionJPA;
import com.basic.core.jpa.vo.UserPermissionView;
import com.basic.core.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private PermissionJPA permissionJPA;

    @Override
    public List<UserPermissionView> getUserPermission(String username) {
        return permissionJPA.getUserPermission(username);
    }
}
