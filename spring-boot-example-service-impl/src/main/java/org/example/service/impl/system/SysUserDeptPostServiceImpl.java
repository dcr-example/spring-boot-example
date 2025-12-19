package org.example.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.system.SysUserDeptPostMapper;
import org.example.model.system.SysUserDeptPost;
import org.example.service.system.SysUserDeptPostService;
import org.springframework.stereotype.Service;

@Service
public class SysUserDeptPostServiceImpl extends ServiceImpl<SysUserDeptPostMapper, SysUserDeptPost> implements SysUserDeptPostService<SysUserDeptPost> {

}
