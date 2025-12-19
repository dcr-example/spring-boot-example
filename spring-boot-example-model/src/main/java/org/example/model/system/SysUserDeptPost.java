package org.example.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统_用户|组织|职位关系表
 */
@Entity
@Table(name = "sys_user_dept_post")
@TableName("sys_user_dept_post")
public class SysUserDeptPost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Long id;
    @Column(name = "user_id")//用户编号
    @TableField("user_id")//用户编号
    private Long userId;
    @Column(name = "dept_id")//组织编号
    @TableField("dept_id")//组织编号
    private Long deptId;
    @Column(name = "post_id")//职位编号
    @TableField("post_id")//职位编号
    private Long postId;
    @Column(name = "is_primary")//是否主职位{0: 否; 1: 是}
    @TableField("is_primary")//是否主职位{0: 否; 1: 是}
    private Integer isPrimary;
    @Column(name = "create_time")//创建时间
    @TableField("create_time")//创建时间
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Integer getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
