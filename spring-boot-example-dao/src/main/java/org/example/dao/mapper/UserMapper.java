package org.example.dao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.model.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper{

    public User queryById(Long id);

    public List<User> queryList(Map<String, Object> map);

    public int add(User user);

    public int remove(Long id);

}
