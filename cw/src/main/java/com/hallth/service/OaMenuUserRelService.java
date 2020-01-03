package com.hallth.service;

import com.hallth.domain.OaMenuUserRel;
import com.hallth.mapper.OaMenuUserRelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaMenuUserRelService {
    @Resource
    private OaMenuUserRelMapper oaMenuUserRelMapper;

    public List<OaMenuUserRel> getMenuIdByUserId(String userId){
        OaMenuUserRel rel = new OaMenuUserRel();
        rel.setUserId(userId);
        return oaMenuUserRelMapper.getMenuIdByUserId(rel);
    }
}
