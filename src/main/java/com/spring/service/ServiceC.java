/**
 * 
 */
package com.spring.service;

import java.util.List;

import com.spring.model.UserModel;

/**
 * @author Administrator
 *
 */
public interface ServiceC {
	
	void save(UserModel model);
	
	void update(UserModel model);
	
	void modifyPassword(String password, String oldPassword);
	
	UserModel findOne(Long id);
	
	List<UserModel> findAll();
	
	UserModel login(String userName, String password);
	
	boolean checkUserName(String userName);
	
}
