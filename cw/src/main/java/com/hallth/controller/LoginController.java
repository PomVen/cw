package com.hallth.controller;

import com.alibaba.fastjson.JSONObject;
import com.hallth.domain.CwUser;
import com.hallth.domain.OaMenu;
import com.hallth.domain.OaMenuUserRel;
import com.hallth.domain.OaMenuView;
import com.hallth.service.OaMenuService;
import com.hallth.service.OaMenuUserRelService;
import com.hallth.service.UserService;
import com.hallth.utils.Constants;
import com.hallth.utils.MenuUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private UserService userService;
    @Resource
    private OaMenuUserRelService oaMenuUserRelService;
    @Resource
    private OaMenuService oaMenuService;
    @Resource
    private MenuUtils menuUtils;

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
        model.addAttribute("userName",userName);
        CwUser loginUser = userService.loginCheck(user);
        if(loginUser != null){
            if(loginUser.getUserStatus() == Constants.USERSTATUS.NOMAL.getKey()){
                logger.info("用户【" + userName + "】登录校验通过！");
                List<OaMenuUserRel> oaMenuUserRelList = oaMenuUserRelService.getMenuIdByUserId(loginUser.getUserId());
                List<OaMenu> oaMenuList = oaMenuService.getMenuById(oaMenuUserRelList);
                List<OaMenuView> oaMenuViewList = menuUtils.getMenuView(oaMenuList);
                logger.info("菜单data：{" + JSONObject.toJSONString(oaMenuViewList) + "}");
                if(oaMenuList != null && oaMenuList.size() > 0){
                    model.addAttribute("oaMenu",oaMenuList);
                }
                model.addAttribute("loginUser",loginUser);
                return "oa/home";
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
