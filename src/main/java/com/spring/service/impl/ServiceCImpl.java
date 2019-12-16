/**
 * 
 */
package com.spring.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.exception.SpringRuntimeException;
import com.spring.mapper.MapperC;
import com.spring.model.UserModel;
import com.spring.service.ServiceC;
import com.spring.utils.BCryptUtils;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class ServiceCImpl implements ServiceC {
	
	@Autowired
	MapperC mapperC;
	
	@Autowired
	HttpSession session;

	@Override
	public void save(UserModel model) {
		// TODO Auto-generated method stub
		if(model == null){
			throw new SpringRuntimeException("用户信息为空,无法保存");
		}
		UserModel user = mapperC.selectOneByName(model.getUserName());
		if(user != null){
			throw new SpringRuntimeException("用户名存在,请更换");
		}
		String password = model.getPassword();
		model.setPassword(BCryptUtils.encode(password));
		mapperC.insertUser(model);
	}


	@Override
	public UserModel findOne(Long id) {
		// TODO Auto-generated method stub
		return mapperC.selectOne(id);
	}


	@Override
	public void update(UserModel model) {
		// TODO Auto-generated method stub
		model.setPassword(null);
		mapperC.updateUser(model);
	}
	@Override
	public void modifyPassword(String password, String oldPassword) {
		// TODO Auto-generated method stub
		Object o = session.getAttribute("userId");
		if(o == null){
			throw new SpringRuntimeException("用户未登录");
		}
		Long userId = Long.valueOf(o+"");
		UserModel user = this.findOne(Long.valueOf(userId));
		if(user == null){
			throw new SpringRuntimeException("用户不存在");
		}
		if(!BCryptUtils.matches(oldPassword, user.getPassword())){
			throw new SpringRuntimeException("密码验证失败");
		}
		mapperC.updateUserPassword(BCryptUtils.encode(password), userId);
	}


	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return mapperC.selectAll();
	}


	@Override
	public UserModel login(String userName, String password) {
		// TODO Auto-generated method stub
		UserModel user = mapperC.selectOneByName(userName);
		if(user == null){
			throw new SpringRuntimeException("用户不存在");
		}
		if(!BCryptUtils.matches(password, user.getPassword())){
			throw new SpringRuntimeException("密码验证失败");
		}
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("userVo", user);
		return user;
	}


	@Override
	public boolean checkUserName(String userName) {
		// TODO Auto-generated method stub
		UserModel user = mapperC.selectOneByName(userName);
		if(user != null){
			return false;
		}
		return true;
	}
	
}
