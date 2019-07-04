package com.basic.core.jpa.bean;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@SqlResultSetMapping(name ="getUserPermission", classes = {
        @ConstructorResult(targetClass = UserPermissionView.class,columns = {
                @ColumnResult(name = "userId", type = Long.class),
                @ColumnResult(name = "nickname", type = String.class),
                @ColumnResult(name = "roleId", type = Long.class),
                @ColumnResult(name = "roleName", type = String.class),
                @ColumnResult(name = "menuCode", type = String.class),
                @ColumnResult(name = "permissionCode", type = String.class)
        })
})
public class UserPermissionView implements Serializable {

    public UserPermissionView(Long userId, String nickname, Long roleId, String roleName, String menuCode, String permissionCode) {
        this.userId = userId;
        this.nickname = nickname;
        this.roleId = roleId;
        this.roleName = roleName;
        this.menuCode = menuCode;
        this.permissionCode = permissionCode;
    }

    public UserPermissionView() {
    }

    private Long userId;

    private String nickname;

    private Long roleId;

    private String roleName;

    private String menuCode;

    private String permissionCode;

    Set<String> menuList = new HashSet<>();

    Set<String> permissionList = new HashSet<>();

    public Set<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(Set<String> menuList) {
        this.menuList = menuList;
    }

    public Set<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Set<String> permissionList) {
        this.permissionList = permissionList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
}
