package com.basic.core.jpa.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="sys_role")
public class RoleInfo implements Serializable {
    /**
     *     `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
     *             `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
     *   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     *             `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "delete_status")
    private Integer deletStatus;

    public Integer getDeletStatus() {
        return deletStatus;
    }

    public void setDeletStatus(Integer deletStatus) {
        this.deletStatus = deletStatus;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    @OneToMany(targetEntity = SysRolePermission.class,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY,
            mappedBy = "roleInfo")
    private Set<SysRolePermission> sysRolePermissionSet = new HashSet<SysRolePermission>();

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
