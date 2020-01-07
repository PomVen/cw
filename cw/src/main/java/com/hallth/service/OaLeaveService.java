package com.hallth.service;

import com.hallth.domain.OaLeaveInfo;
import com.hallth.mapper.OaLeaveInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OaLeaveService {
    @Resource
    private OaLeaveInfoMapper leaveInfoMapper;

    public int submitLeaveProcess(OaLeaveInfo param) {
        return leaveInfoMapper.insert(param);
    }

    public int saveLeaveProcess(OaLeaveInfo param) {
        return leaveInfoMapper.insert(param);
    }

    public int commitLeaveProcess(OaLeaveInfo param) {
        return leaveInfoMapper.updateByPrimaryKey(param);
    }
}
