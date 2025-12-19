package org.example.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统_用户表
 */
@Entity
@Table(name = "sys_user")
@TableName("sys_user")
public class SysUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Long id;
    @Column(name = "user_name")//用户名
    @TableField("user_name")//用户名
    private String userName;
    @Column(name = "user_pwd")//密码
    @TableField("user_pwd")//密码
    private String userPwd;
    @Column(name = "salt")//盐
    @TableField("salt")//盐
    private String salt;
    @Column(name = "token")//Token
    @TableField("token")//Token
    private String token;
    @Column(name = "iphone")//手机号
    @TableField("iphone")//手机号
    private String iphone;
    @Column(name = "email")//邮箱
    @TableField("email")//邮箱
    private String email;
    @Column(name = "address")//住址
    @TableField("address")//住址
    private String address;
    @Column(name = "photo")//照片
    @TableField("photo")//照片
    private String photo;
    @Column(name = "profile")//头像
    @TableField("profile")//头像
    private String profile;
    @Column(name = "status")//帐号状态{0: 正常；1：禁用}
    @TableField("status")//帐号状态{0: 正常；1：禁用}
    private Integer status;
    @Column(name = "staff_status")//员工状态{0: 在职；1：离职}
    @TableField("staff_status")//员工状态{0: 在职；1：离职}
    private Integer staffStatus;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(Integer staffStatus) {
        this.staffStatus = staffStatus;
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
