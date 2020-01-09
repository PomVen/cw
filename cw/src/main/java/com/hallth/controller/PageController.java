package com.hallth.controller;

import com.hallth.domain.CwUser;
import com.hallth.utils.SeqUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
public class PageController {
    private static Logger logger = Logger.getLogger(PageController.class.getName());

    @Resource
    private SeqUtils seqUtils;

    @RequestMapping(value="/toBaseInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String toBaseInfo(HttpServletRequest request, Model model){
        CwUser loginUser = (CwUser)request.getSession().getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        return "oa/personInfo/baseInfo";
    }

    @RequestMapping(value="/toLeave", method = {RequestMethod.GET, RequestMethod.POST})
    public String toLeave(HttpServletRequest request, Model model){
        model.addAttribute("leaveId", "L_" + seqUtils.getNextId("leave"));
        CwUser loginUser = (CwUser)request.getSession().getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        return "oa/baseFunction/leave";
    }

    @RequestMapping(value="/toReimbursement", method = {RequestMethod.GET, RequestMethod.POST})
    public String toReimbursement(HttpServletRequest request){
        return "oa/baseFunction/reimbursement";
    }

    @RequestMapping(value="/toSuggestOnline", method = {RequestMethod.GET, RequestMethod.POST})
    public String toSuggestOnline(HttpServletRequest request){
        return "oa/suggest/suggestOnLine";
    }

    @RequestMapping(value="/toOaProcessQuery", method = {RequestMethod.GET, RequestMethod.POST})
    public String toOaProcessQuery(HttpServletRequest request){
        return "oa/baseFunction/oaProcessQuery";
    }
}
