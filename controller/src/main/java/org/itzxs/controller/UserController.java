package org.itzxs.controller;

import org.itzxs.constant.MessageVar;
import org.itzxs.entity.UserInformation;
import org.itzxs.result.JsonResult;
import org.itzxs.service.UserService;
import org.itzxs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Itzxs on 2018/5/25.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(types = {UserInformation.class, String.class}, value = {"userInformation"})
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/f_login")
    @ResponseBody
    public JsonResult login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Valid UserInformation userInformation){
        if(userInformation == null || StringUtil.isEmpty(userInformation.getPassWord())){
            return new JsonResult(0, MessageVar.PASS_WORD_NOT_EMPTY,null);
        }
        userInformation = userService.login(userInformation);
        if(userInformation == null || StringUtil.isEmpty(userInformation.getUserName())){
            return new JsonResult(0, MessageVar.LOGIN_USER_PWD_ERROR,null);
        }
        return new JsonResult(1,JsonResult.SUCCESS,userInformation);
    }

    @RequestMapping(value = "/f_register")
    @ResponseBody
    public JsonResult register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Valid UserInformation userInformation){
        if(userInformation == null || StringUtil.isEmpty(userInformation.getPassWord())){
            return new JsonResult(0, MessageVar.PASS_WORD_NOT_EMPTY,null);
        }
        if(!userService.register(userInformation)){
            return new JsonResult(0, MessageVar.REGISTER_ERROR,null);
        }
        return new JsonResult(1,JsonResult.SUCCESS,userInformation);
    }
}
