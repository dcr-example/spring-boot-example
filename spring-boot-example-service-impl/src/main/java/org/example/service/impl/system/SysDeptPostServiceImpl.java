package org.example.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.system.SysDeptPostMapper;
import org.example.model.system.SysDeptPost;
import org.example.service.system.SysDeptPostService;
import org.springframework.stereotype.Service;

@Service
public class SysDeptPostServiceImpl extends ServiceImpl<SysDeptPostMapper, SysDeptPost> implements SysDeptPostService<SysDeptPost> {

}
