package com.hallth.controller;

import com.hallth.domain.OaLeaveInfo;
import com.hallth.domain.RespMap;
import com.hallth.service.OaLeaveService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    private static Logger logger = Logger.getLogger(LeaveController.class.getName());

    @Resource
    private OaLeaveService leaveService;

    @RequestMapping(value="/addLeave", method = {RequestMethod.GET, RequestMethod.POST})
    public RespMap addLeave(HttpServletRequest request){
        RespMap map = new RespMap();
        int flag = Integer.parseInt(request.getParameter("flag"));
        OaLeaveInfo param = getParam(request);
        int res = 0;
        if(flag == 1){ //提交并保存
            param.setLeaveStatus("4");//设置为待审核
            res = leaveService.submitLeaveProcess(param);
            map.setResult(res > 0 ? true : false);
            map.setMsg(res > 0 ? "提交并保存成功" : "提交并保存失败");
        } else if(flag == 2){ //保存
            param.setLeaveStatus("3");//设置为待提交
            res = leaveService.saveLeaveProcess(param);
            map.setResult(res > 0 ? true : false);
            map.setMsg(res > 0 ? "保存成功" : "保存失败");
        } else if(flag == 3){
            param.setLeaveStatus("4");//设置为待审核
            res = leaveService.commitLeaveProcess(param);
            map.setResult(res > 0 ? true : false);
            map.setMsg(res > 0 ? "提交成功" : "提交失败");
        }
        return map;
    }

    private OaLeaveInfo getParam(HttpServletRequest request){
        String leaveId = request.getParameter("leaveId");
        String createUser = request.getParameter("userId");
        String createTime = request.getParameter("createTime");
        String leaveType = request.getParameter("leaveType");
        String leaveStartTime = request.getParameter("leaveStartTime");
        String leaveEndTime = request.getParameter("leaveEndTime");
        String leaveDesc = request.getParameter("leaveDesc");
        OaLeaveInfo leaveInfo = new OaLeaveInfo();
        leaveInfo.setCreateUser(createUser);
        leaveInfo.setLeaveId(leaveId);
        leaveInfo.setLeaveType(Integer.parseInt(leaveType));
        Date lsd = new Date(leaveStartTime);
        Date led = new Date(leaveEndTime);
        long ldc = ((led.getTime() - lsd.getTime()) / (86400000L));
        if(((led.getTime() - lsd.getTime()) % (86400000L)) > 0){
            leaveInfo.setLeaveDayCount((float)ldc + 0.5F);
        } else {
            leaveInfo.setLeaveDayCount((float)ldc);
        }
        leaveInfo.setLeaveStartTime(lsd);
        leaveInfo.setLeaveEndTime(led);
        leaveInfo.setLeaveDesc(leaveDesc);
        return leaveInfo;
    }
}
