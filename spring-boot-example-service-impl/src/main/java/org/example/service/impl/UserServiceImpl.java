package org.example.service.impl;

import org.example.dao.mapper.UserMapper;
import org.example.dao.repository.UserRepository;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    public User queryById(Long id){
        System.out.println("UserServiceImpl-> queryById();");
//        return userMapper.queryById(id);
        return userRepository.findById(id).orElse(null);
    }
    public User queryByNameAndPwd(String userName, String userPwd){
        System.out.println("UserServiceImpl-> queryByNameAndPwd();");
//        Map<String, Object> map = new HashMap<>();
//        map.put("userName", userName);
//        map.put("userPwd", userPwd);
//        List<User> list = queryList(map);
//        if(list != null && list.size() > 0){
//            return list.get(0);
//        }else{
//            return null;
//        }

        return userRepository.findByUserNameAndUserPwd(userName, userPwd);
    }


    @Override
    public List<User> queryList(Map<String, Object> map) {
        System.out.println("UserServiceImpl-> queryList();");
//        return userMapper.queryList(map);
        return userRepository.findAll();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(User user) {
//        userMapper.add(user);
        user = userRepository.save(user);
        System.out.println("UserServiceImpl->add() " + user.toString());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void remove(Long id) {
        int result = 0;
//        result = userMapper.remove(id);
        userRepository.deleteById(id);
        System.out.println("UserServiceImpl-> remove() result = " + result);
    }

}
