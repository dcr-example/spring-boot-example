package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="t_user")
//@NamedQuery(name = "User.selectByUserName", query = "select t from User t where t.userName = ?1")
//@NamedQuery(name = "User.selectByUserName.count", query = "select count(t) from User t where t.userName = ?1")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pwd")
    private  String userPwd;

    public User(){}
    public User(String nickName, String userName, String userPwd) {
        this.nickName = nickName;
        this.userName = userName;
        this.userPwd = userPwd;
    }
    public User(Long id, String nickName, String userName, String userPwd) {
        this.id = id;
        this.nickName = nickName;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
}
