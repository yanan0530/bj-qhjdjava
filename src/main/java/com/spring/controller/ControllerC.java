/**
 * 
 */
package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring.model.UserModel;
import com.spring.service.ServiceC;

/**
 * 用户信息
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/C")
public class ControllerC {
	
	@Autowired
	ServiceC serviceC;
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public boolean save(@ModelAttribute UserModel model) {
		serviceC.save(model);
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public boolean update(@ModelAttribute UserModel userModel) {
		System.err.println(userModel);
		serviceC.update(userModel);
		return true;
	}

	/**
	 * 修改密码
	 * @param password
	 * @param old
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public boolean modify(@RequestParam String password, @RequestParam String old) {
		this.serviceC.modifyPassword(password, old);
		return true;
	}

	/**
	 * 查找指定用户
	 * @param model
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public String findOne(Model model, @RequestParam Long userId) {
		model.addAttribute("vo", serviceC.findOne(userId));
		return "user/show";
	}

	/**
	 * 查看所有用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<?> findList() {
		return serviceC.findAll();
	}
	//登录
	@RequestMapping(value = "/toUser", method = RequestMethod.GET)
	public String toUser(){
		return "user";
	}
	//zhuce
	@RequestMapping(value = "/toRegistered",method = RequestMethod.GET)
	public String toRegistered(){
		return "registered";
	}

	@RequestMapping(value = "toUserInfo",method = RequestMethod.GET)
	public String toUserinfo(){
		return "user/userinfo";
	}
	@RequestMapping(value = "toUserPassword",method = RequestMethod.GET)
	public String toUserPassword(){
		return "user/userpassword";
	}

	@ResponseBody
	@RequestMapping(value = "/checkUserName", method = RequestMethod.GET)
	public boolean checkUserName(@RequestParam String userName){
		return serviceC.checkUserName(userName);
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserModel login(@RequestParam String userName, @RequestParam String password){
		return serviceC.login(userName, password);
	}

}
