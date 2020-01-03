package com.hallth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping(value="/toBaseInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String toBaseInfo(HttpServletRequest request){
        return "oa/personInfo/baseInfo";
    }
    @RequestMapping(value="/toLeave", method = {RequestMethod.GET, RequestMethod.POST})
    public String toLeave(HttpServletRequest request){
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
}
