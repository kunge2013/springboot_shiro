package com.basic.core.jpa.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="sys_permission")
public class SysPermission implements Serializable {
    /**
     *  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
     *   `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
     *   `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
     *   `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
     *   `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
     *   `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "menu_code")
    private String menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "permission_code")
    private String permissionCode;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "required_permission")
    private Integer requiredPermission;

    @OneToMany(targetEntity = SysRolePermission.class,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY,
            mappedBy = "sysPermission")
    private Set<SysRolePermission> sysRolePermissionSet = new HashSet<SysRolePermission>();

    public Set<SysRolePermission> getSysRolePermissionSet() {
        return sysRolePermissionSet;
    }

    public void setSysRolePermissionSet(Set<SysRolePermission> sysRolePermissionSet) {
        this.sysRolePermissionSet = sysRolePermissionSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(Integer requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
}
