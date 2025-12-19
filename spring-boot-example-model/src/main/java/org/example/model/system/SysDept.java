package org.example.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统_组织表
 */
@Entity
@Table(name = "sys_dept")
@TableName("sys_dept")
public class SysDept implements Serializable {

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
    @Column(name = "level")//层级 默认：1
    @TableField("level")//层级 默认：1
    private Integer level;
    @Column(name = "parent_id")//上级编号
    @TableField("parent_id")//上级编号
    private Long parentId;
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
