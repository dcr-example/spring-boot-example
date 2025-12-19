package org.example.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.system.SysRoleAuthMapper;
import org.example.model.system.SysRoleAuth;
import org.example.service.system.SysRoleAuthService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleAuthServiceImpl extends ServiceImpl<SysRoleAuthMapper, SysRoleAuth> implements SysRoleAuthService<SysRoleAuth> {

}
