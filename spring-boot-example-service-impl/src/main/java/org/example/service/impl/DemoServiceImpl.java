package org.example.service.impl;

import org.example.dao.mapper.DemoMapper;
import org.example.dao.repository.DemoRepository;
import org.example.model.Demo;
import org.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
public class DemoServiceImpl implements DemoService {
////
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private DemoRepository demoRepository;

    public Demo queryById(Long id){
        System.out.println("DemoServiceImpl-> queryById();");
//        return demoMapper.queryById(id);
        return demoRepository.findById(id).orElse(null);
    }
    @Override
    public List<Demo> queryList(Map<String, Object> map) {
        System.out.println("DemoServiceImpl-> queryList();");
//        return demoMapper.queryList(map);
        return demoRepository.findAll();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Demo demo) {
//        demoMapper.add(demo);
        demo = demoRepository.save(demo);
        System.out.println("DemoServiceImpl->add() " + demo.toString());
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void remove(Long id) {
        int result = 0;
//        result = demoMapper.remove(id);
        demoRepository.deleteById(id);
        System.out.println("DemoServiceImpl-> remove() result = " + result);
    }

}
