package com.hallth.controller;

import com.hallth.domain.CwUser;
import com.hallth.domain.OaEduHis;
import com.hallth.domain.OaLeaveInfo;
import com.hallth.domain.RespMap;
import com.hallth.service.OaEduHisService;
import com.hallth.utils.MathUtils;
import com.hallth.utils.SeqUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/edu")
public class EduHisController {
    private static Logger logger = Logger.getLogger(EduHisController.class.getName());

    @Resource
    private OaEduHisService eduHisService;
    @Resource
    private SeqUtils seqUtils;

    @RequestMapping(value="/getEduHisInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public Map addLeave(HttpServletRequest request){
        Map map = new HashMap();
        CwUser user = (CwUser)request.getSession().getAttribute("loginUser");
        String schoolName = request.getParameter("schoolName");
        String startTime = request.getParameter("startTime");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        String userId = user.getUserId();
        OaEduHis param = new OaEduHis();
        param.setUserId(userId);
        if(schoolName != null && !schoolName.trim().isEmpty()){
            schoolName = "%" + schoolName.trim() + "%";
            param.setSchoolName(schoolName.trim());
        }
        if(startTime != null && !startTime.trim().isEmpty()){
            param.setStartTime(new Date(startTime.trim()));
        }
        param.setPageSize(pageSize);
        param.setStartRow(MathUtils.getStartRow(currentPage,pageSize));
        List<OaEduHis> list = eduHisService.getEduHisInfoByUserId(param);
        int total = eduHisService.getEduHisInfoByUserIdCount(param);
        map.put("total", total);
        map.put("rows",list);
        return map;
    }

    @RequestMapping(value="/addEduHis", method = {RequestMethod.GET, RequestMethod.POST})
    public RespMap addEduHis(HttpServletRequest request){
        RespMap map = new RespMap();
        OaEduHis param = new OaEduHis();
        String userId = request.getParameter("userId");
        String schoolName = request.getParameter("schoolName");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String major = request.getParameter("major");
        String degree = request.getParameter("degree");
        int schoolType = Integer.parseInt(request.getParameter("schoolType"));
        param.setUserId(userId);
        param.setSchoolName(schoolName);
        param.setSchoolType(schoolType);
        Date sd = new Date(startTime);
        Date ed = new Date(endTime);
        param.setStartTime(sd);
        param.setEndTime(ed);
        param.setMajor(major);
        param.setDegree(degree);
        param.setId("edu_" + seqUtils.getNextId("edu_his"));
        int res = eduHisService.addEduHis(param);
        map.setResult(res > 0 ? true : false);
        map.setMsg(res > 0 ? "添加成功" : "添加失败");
        return map;
    }

}
