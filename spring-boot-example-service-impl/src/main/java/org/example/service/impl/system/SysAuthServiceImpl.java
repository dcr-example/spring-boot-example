package org.example.service.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.system.SysAuthMapper;
import org.example.model.system.SysAuth;
import org.example.service.system.SysAuthService;
import org.springframework.stereotype.Service;

@Service
public class SysAuthServiceImpl extends ServiceImpl<SysAuthMapper, SysAuth> implements SysAuthService<SysAuth> {

}
