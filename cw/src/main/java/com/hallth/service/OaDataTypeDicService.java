package com.hallth.service;

import com.hallth.domain.OaDataTypeDic;
import com.hallth.mapper.OaDataTypeDicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaDataTypeDicService {
    @Resource
    private OaDataTypeDicMapper dataTypeDicMapper;

    public List<OaDataTypeDic> getOaLeaveTypeList(){
        return dataTypeDicMapper.getOaLeaveTypeList();
    }

    public List<OaDataTypeDic> getSchoolTypeList() {
        return dataTypeDicMapper.getSchoolTypeList();
    }
}
