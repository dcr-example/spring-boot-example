package org.example.service;


import org.example.model.Demo;

import java.util.List;
import java.util.Map;

public interface DemoService {
    public Demo queryById(Long id);
    public List<Demo> queryList(Map<String, Object> map);
    public void add(Demo demo);
    public void remove(Long id);

}
