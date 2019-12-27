package com.hallth.service;

import com.hallth.domain.CwUser;
import com.hallth.mapper.CwUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private CwUserMapper userMapper;

    public CwUser loginCheck(CwUser user) {
        return userMapper.getUser(user);
    }
}
