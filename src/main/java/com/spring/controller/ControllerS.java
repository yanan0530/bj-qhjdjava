package com.spring.controller;

import com.spring.model.ArcTypeModel;
import com.spring.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerS {
    @Autowired
    ServiceB serviceB;

    @RequestMapping("/search")
    public String admin(@RequestParam("number") String number, Model model) {
        model.addAttribute("list",serviceB.selectOneByNumber(number));
        return "search";
    }
   @RequestMapping("/searchm")
    public String mAdmin(@RequestParam("number") String number, Model model) {
       model.addAttribute("list", serviceB.selectOneByNumber(number));
       return "searchm";
   }
}
