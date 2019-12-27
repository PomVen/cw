package com.hallth.controller;

import com.hallth.domain.CwUser;
import com.hallth.service.UserService;
import com.hallth.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private UserService userService;

    @RequestMapping(value="/loginCheck", method = {RequestMethod.GET, RequestMethod.POST})
    public String addUser(@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword,
                          HttpServletRequest request, Model model){
        logger.info("用户【" + userName + "】登录校验");
        if(userName.trim().isEmpty() || userPassword.trim().isEmpty()){
            logger.info("用户名或密码为空");
            model.addAttribute("errMsg","用户名或密码为空！");
            return "login/login";
        }
        CwUser user = new CwUser();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        CwUser loginUser = userService.loginCheck(user);
        if(loginUser != null){
            if(loginUser.getUserStatus() == Constants.USERSTATUS.NOMAL.getKey()){
                logger.info("用户【" + userName + "】登录校验通过！");
                model.addAttribute("loginUser",loginUser);
                return "cw/home";
            } else {
                logger.info("用户【" + userName + "】状态为" + Constants.USERSTATUS.values()[loginUser.getUserStatus()].getValue());
                model.addAttribute("errMsg","用户【" + userName + "】状态为" + Constants.USERSTATUS.values()[loginUser.getUserStatus()].getValue());
                return "login/login";
            }
        } else {
            logger.info("用户【" + userName + "】不存在或密码错误！");
            model.addAttribute("errMsg","用户【" + userName + "】不存在或密码错误！");
            return "login/login";
        }
    }

    @RequestMapping(value="/loginOut", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();//删除session
        return "login/login";
    }

}
