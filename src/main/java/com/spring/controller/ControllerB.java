/**
 * 
 */
package com.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.exception.SpringRuntimeException;
import com.spring.service.ServiceB;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/B")
public class ControllerB {
	
	@Autowired
	ServiceB serviceB;
	
//	@ResponseBody
//	@RequestMapping("update")
//	public boolean updateList() {
//		serviceB.update();
//		return true;
//	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", serviceB.list());
		return "list/list";
	}
	@RequestMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("list", serviceB.list());
		return "admin";
	}

	@RequestMapping("/print")
	public String doPrint(Model model) {
		model.addAttribute("imgs", serviceB.printList());
		return "list/print";
	}
	
	@RequestMapping("/prints")
	public String doPrint(Model model, Long... ids) {
		model.addAttribute("imgs", serviceB.printByIds(ids));
		return "list/print";
	}
	@CrossOrigin(origins = "*")
    @RequestMapping("/prints2")
    public String doPrint2(Model model, Long... ids) {
        model.addAttribute("imgs", serviceB.printByPjbh(ids));
        return "list/print";
    }

	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public String doPrints(String number, HttpServletResponse respon) {
//		model.addAttribute("list", serviceB.selectOneByNumber(number));
		if(serviceB.selectOneByNumber(number) == null){
			throw new SpringRuntimeException("暂无此单号");
		}
//		try {
//			
//			respon.sendRedirect(serviceB.selectOneByNumber(number).getPrintUrl());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return serviceB.selectOneByNumber(number).getPrintUrl();
	}
	
	@ResponseBody
	@RequestMapping(value = "/ones", method = RequestMethod.GET)
	public void doPrintss(String number, HttpServletResponse respon) {
//		model.addAttribute("list", serviceB.selectOneByNumber(number));
		if(serviceB.selectOneByNumber(number) == null){
			throw new SpringRuntimeException("暂无此单号");
		}
		try {
			
			respon.sendRedirect(serviceB.selectOneByNumber(number).getPrintUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@ResponseBody
	@RequestMapping(value = "/oness", method = RequestMethod.GET)
	public void doPrintsss(String number, HttpServletResponse respon) {
//		model.addAttribute("list", serviceB.selectOneByNumber(number));
		respon.setHeader("Access-Control-Allow-Origin", "*");
		respon.setHeader("Cache-Control","no-cache"); 
		if(serviceB.selectOneByNumber(number) == null){
			throw new SpringRuntimeException("暂无此单号");
		}
		try {
			respon.sendRedirect(serviceB.selectOneByNumber(number).getPrintUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
