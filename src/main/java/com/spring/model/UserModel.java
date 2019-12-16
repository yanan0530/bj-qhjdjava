/**
 * 
 */
package com.spring.model;

import java.math.BigDecimal;

/**
 * @author Administrator
 *
 */
public class UserModel {
	
	Long userId;
	
	String userName;
	
	String userAccount;
	
	String password;
	
	String userPhone;
	
	String userEmail;
	
	String userSex;
	
	String userBirthday;
	
	String userRealName;
	
	BigDecimal file1;
	
	BigDecimal file2;
	
	String file3;
	
	String file4;

	public String getUserRealName() {
		return userRealName;
	}
	
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public BigDecimal getFile1() {
		return file1;
	}

	public void setFile1(BigDecimal file1) {
		this.file1 = file1;
	}

	public BigDecimal getFile2() {
		return file2;
	}

	public void setFile2(BigDecimal file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	public String getFile4() {
		return file4;
	}

	public void setFile4(String file4) {
		this.file4 = file4;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", userAccount=" + userAccount + ", password="
				+ password + ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", userSex=" + userSex
				+ ", userBirthday=" + userBirthday + ", file1=" + file1 + ", file2=" + file2 + ", file3=" + file3
				+ ", file4=" + file4 + "]";
	}
	
}
