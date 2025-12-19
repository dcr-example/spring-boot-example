package org.example.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.system.SysUserMapper;
import org.example.model.system.SysUser;
import org.example.service.system.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService<SysUser> {

}
