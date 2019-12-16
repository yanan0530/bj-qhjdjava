/**
 * 
 */
package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.MapperA;
import com.spring.service.ServiceA;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class ServiceAImpl implements ServiceA {

	@Autowired
	MapperA ma;

	public Object getAll() {
		// TODO Auto-generated method stub
		return ma.selectAll();
	}

	public static void main(String[] args) {
//		String a = "<img alt='' src='/uploads/allimg/190423/1-1Z423110II27.jpg' style='width: 650px; height: 888px;'/>";
//
//		System.err.println(getImg(a));
//		;
//		System.err.println(a.substring(a.lastIndexOf("src"), 15));
	}

	public static String getImg(String s) {
		String regex;
		List<String> list = new ArrayList<String>();
		regex = "src='(.*?)'";
		Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		Matcher ma = pa.matcher(s);
		while (ma.find()) {
			return (ma.group().substring(5, ma.group().length()-1));
		}
		return null;
	}
}