package org.example.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.system.SysUserRoleMapper;
import org.example.model.system.SysUserRole;
import org.example.service.system.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService<SysUserRole> {

}
