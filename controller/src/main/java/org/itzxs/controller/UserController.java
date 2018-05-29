package org.itzxs.controller;

import org.itzxs.entity.UserInformation;
import org.itzxs.service.UserService;
import org.itzxs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Valid UserInformation userInformation){
        ModelAndView modelAndView = new ModelAndView();
        if(userInformation == null || StringUtil.isEmpty(userInformation.getPassWord())){
            modelAndView.setViewName("/login");
            return modelAndView;
        }
        userInformation = userService.login(userInformation);
        if(userInformation == null || StringUtil.isEmpty(userInformation.getUserId())){
            modelAndView.setViewName("/login");
            return modelAndView;
        }
        modelAndView.addObject("userInformation",userInformation);
        modelAndView.setViewName("/book/bookList");
        return modelAndView;
    }
}
