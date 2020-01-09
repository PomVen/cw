package com.hallth.service;

import com.hallth.domain.OaEduHis;
import com.hallth.mapper.OaEduHisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaEduHisService {

    @Resource
    private OaEduHisMapper eduHisMapper;

    public List<OaEduHis> getEduHisInfoByUserId(OaEduHis param){
        return eduHisMapper.getEduHisInfoByUserId(param);
    }

    public int getEduHisInfoByUserIdCount(OaEduHis param) {
        return eduHisMapper.getEduHisInfoByUserIdCount(param);
    }

    public int addEduHis(OaEduHis param) {
        return eduHisMapper.insert(param);
    }
}
