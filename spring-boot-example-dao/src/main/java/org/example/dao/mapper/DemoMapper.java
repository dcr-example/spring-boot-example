package org.example.dao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.model.Demo;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoMapper {

    public Demo queryById(Long id);
    public List<Demo> queryList(Map<String, Object> map);

    public int add(Demo demo);

    public int remove(Long id);

}
