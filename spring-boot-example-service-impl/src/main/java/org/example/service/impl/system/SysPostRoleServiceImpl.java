package org.example.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.system.SysPostRoleMapper;
import org.example.model.system.SysPostRole;
import org.example.service.system.SysPostRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysPostRoleServiceImpl extends ServiceImpl<SysPostRoleMapper, SysPostRole> implements SysPostRoleService<SysPostRole> {

}
