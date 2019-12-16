/**
 * 
 */
package com.spring.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.spring.model.UserModel;

/**
 * @author WYY
 *
 */
public class MapperCProvider {

	public String insertUser(UserModel user) {
		SQL sql = new SQL();
		sql.INSERT_INTO("user_info ");
		if (user.getUserId() != null) {
			sql.VALUES("user_id_", "#{userId,jdbcType=BIGINT}");
		}
		if (user.getUserName() != null) {
			sql.VALUES("user_name_", "#{userName,jdbcType=VARCHAR}");
		}
		if (user.getUserAccount() != null) {
			sql.VALUES("user_account_", "#{userAccount,jdbcType=VARCHAR}");
		}
		if (user.getPassword() != null) {
			sql.VALUES("user_password_", "#{password,jdbcType=VARCHAR}");
		}
		if (user.getUserPhone() != null) {
			sql.VALUES("user_phone_", "#{userPhone,jdbcType=VARCHAR}");
		}
		if (user.getUserEmail() != null) {
			sql.VALUES("user_email_", "#{userEmail,jdbcType=VARCHAR}");
		}
		if (user.getUserSex() != null) {
			sql.VALUES("user_sex_", "#{userSex,jdbcType=VARCHAR}");
		}
		if (user.getUserBirthday() != null) {
			sql.VALUES("user_birthday_", "#{userBirthday,jdbcType=VARCHAR}");
		}
		if (user.getUserRealName() != null) {
			sql.VALUES("user_real_name_", "#{userRealName,jdbcType=VARCHAR}");
		}
		if (user.getFile1() != null) {
			sql.VALUES("file1", "#{file1,jdbcType=DECIMAL}");
		}
		if (user.getFile2() != null) {
			sql.VALUES("file2", "#{file2,jdbcType=DECIMAL}");
		}
		if (user.getFile3() != null) {
			sql.VALUES("file3", "#{file3,jdbcType=VARCHAR}");
		}
		if (user.getFile4() != null) {
			sql.VALUES("file4", "#{file4,jdbcType=VARCHAR}");
		}
		return sql.toString();
	}

	public String updateUser(UserModel user) {
		SQL sql = new SQL();
		sql.UPDATE("user_info ");
		if (user.getUserName() != null) {
			sql.SET("user_name_ = #{userName,jdbcType=VARCHAR}");
		}
		if (user.getUserAccount() != null) {
			sql.SET("user_account_ = #{userAccount,jdbcType=VARCHAR}");
		}
		if (user.getPassword() != null) {
			sql.SET("user_password_ = #{password,jdbcType=VARCHAR}");
		}
		if (user.getUserPhone() != null) {
			sql.SET("user_phone_ = #{userPhone,jdbcType=VARCHAR}");
		}
		if (user.getUserEmail() != null) {
			sql.SET("user_email_ = #{userEmail,jdbcType=VARCHAR}");
		}
		if (user.getUserSex() != null) {
			sql.SET("user_sex_ = #{userSex,jdbcType=VARCHAR}");
		}
		if (user.getUserBirthday() != null) {
			sql.SET("user_birthday_ = #{userBirthday,jdbcType=VARCHAR}");
		}
		if (user.getUserRealName() != null) {
			sql.SET("user_real_name_ = #{userRealName,jdbcType=VARCHAR}");
		}
		if (user.getFile1() != null) {
			sql.SET("file1 = #{file1,jdbcType=DECIMAL}");
		}
		if (user.getFile2() != null) {
			sql.SET("file2 = #{file2,jdbcType=DECIMAL}");
		}
		if (user.getFile3() != null) {
			sql.SET("file3 = #{file3,jdbcType=VARCHAR}");
		}
		if (user.getFile4() != null) {
			sql.SET("file4 =  #{file4,jdbcType=VARCHAR}");
		}
		sql.WHERE("user_id_ = #{userId, jdbcType=BIGINT}");
//		System.err.println(sql.toString());
		return sql.toString();

	}

}
