package org.example.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统_权限表
 */
@Entity
@Table(name = "sys_auth")
@TableName("sys_auth")
public class SysAuth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Long id;
    @Column(name = "code")//编码
    @TableField("code")//编码
    private String code;
    @Column(name = "name")//名称
    @TableField("name")//名称
    private String name;
    @Column(name = "path")//路径
    @TableField("path")//路径
    private String path;
    @Column(name = "icon")//图标
    @TableField("icon")//图标
    private String icon;
    @Column(name = "level")//层级 默认：1
    @TableField("level")//层级 默认：1
    private Integer level;
    @Column(name = "parent_id")//上级编号
    @TableField("parent_id")//上级编号
    private Long parentId;
    @Column(name = "auth_type")//权限类型{0: 目录；1：菜单；2：按钮；3：链接}
    @TableField("auth_type")//权限类型{0: 目录；1：菜单；2：按钮；3：链接}
    private Integer authType;
    @Column(name = "status")//状态{0: 正常；1：禁用}
    @TableField("status")//状态{0: 正常；1：禁用}
    private Integer status;
    @Column(name = "create_time")//创建时间
    @TableField("create_time")//创建时间
    private LocalDateTime createTime;
    @Column(name = "update_time")//修改时间
    @TableField("update_time")//修改时间
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
