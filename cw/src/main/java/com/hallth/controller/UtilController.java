package com.hallth.controller;

import com.alibaba.fastjson.JSONObject;
import com.hallth.domain.JSONBean;
import com.hallth.domain.OaDataTypeDic;
import com.hallth.service.OaDataTypeDicService;
import com.hallth.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/util")
public class UtilController {

    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private OaDataTypeDicService oaDataTypeDicService;
    @Resource
    private JsonUtils jsonUtils;

    @RequestMapping(value="/getLeaveTypeList", method = {RequestMethod.GET, RequestMethod.POST})
    public List<JSONBean> getLeaveTypeList(HttpServletRequest request){
        Map map = new HashMap();
        List<OaDataTypeDic> list = oaDataTypeDicService.getOaLeaveTypeList();
        logger.info("请假类型：" + JSONObject.toJSONString(list));
        return jsonUtils.oaDicToJson(list);
    }

}
