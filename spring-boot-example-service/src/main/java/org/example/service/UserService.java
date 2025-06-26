package org.example.service;

import org.example.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User queryById(Long id);
    public User queryByNameAndPwd(String userName, String userPwd);
    public List<User> queryList(Map<String, Object> map);
    public void add(User user);
    public void remove(Long id);
}
