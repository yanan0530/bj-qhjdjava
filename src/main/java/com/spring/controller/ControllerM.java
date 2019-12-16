package com.spring.controller;

import com.spring.model.UserModel;
import com.spring.service.ServiceC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/m")
public class ControllerM {

    @Autowired
    ServiceC serviceC;
    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toUser(HttpSession session) {
        Object o = session.getAttribute("userVo");
       if (o != null) {
            return "m/userinfo";
           }
           return "m/user";
      }
    //注册
    @RequestMapping(value = "/toRegistered",method = RequestMethod.GET)
    public String toRegistered(){
        return "m/registered";
    }


    @RequestMapping(value = {"/signout"}, method = {RequestMethod.GET})
    public String signOut(HttpSession session) {
        session.removeAttribute("");
        session.invalidate();
        return "m/user";
    }

    @ResponseBody
    @RequestMapping(value = {"/logins"}, method = {RequestMethod.GET})
    public UserModel login(@RequestParam String userName, @RequestParam String password) { return this.serviceC.login(userName, password); }



    @RequestMapping(value = "/toUserInfo",method = RequestMethod.GET)
    public String toUserinfo(){
        return "m/userinfo";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String toSearch(){
        return "m/search";
    }
    @RequestMapping(value = {"/toUserDetails"}, method = {RequestMethod.GET})
    public String toUserDetail() { return "m/userdetails"; }

    @RequestMapping(value = {"/toUserPassword"}, method = {RequestMethod.GET})
    public String toUserPassword() { return "m/userpassword"; }





}
