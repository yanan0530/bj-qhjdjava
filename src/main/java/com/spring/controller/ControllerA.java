/**
 * 
 */
package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.ServiceA;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/A")
public class ControllerA {
	
	@Autowired
	ServiceA sa;
	
	@RequestMapping("/all")
	public Object getAll() {
		return sa.getAll();
	}

}
