package com.hallth.service;

import com.hallth.domain.OaMenu;
import com.hallth.domain.OaMenuUserRel;
import com.hallth.mapper.OaMenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaMenuService {
    @Resource
    private OaMenuMapper oaMenuMapper;

    public List<OaMenu> getMenuById(List<OaMenuUserRel> menuIdList){
        return oaMenuMapper.getMenuById(menuIdList);
    }
}
