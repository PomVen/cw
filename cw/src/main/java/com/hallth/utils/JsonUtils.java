package com.hallth.utils;

import com.hallth.domain.JSONBean;
import com.hallth.domain.OaDataTypeDic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonUtils {
    public List<JSONBean> oaDicToJson(List<OaDataTypeDic> list){
        List<JSONBean> res = new ArrayList<>();
        for(OaDataTypeDic item : list){
            res.add(item.toJsonBean());
        }
        return res;
    }
}
