package com.basic.core.service.impl;

import com.basic.core.jpa.bean.SysPermission;
import com.basic.core.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService implements IPermissionService {

    @Override
    public List<SysPermission> getUserPermission(String username) {
        return null;
    }
}
