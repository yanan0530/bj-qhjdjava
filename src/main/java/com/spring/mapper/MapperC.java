/**
 * 
 */
package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.spring.model.UserModel;

/**
 * @author Administrator
 *
 */
@Mapper
public interface MapperC {
	@Select("select * from user_info where user_id_ = #{id}")
	@Results(id = "mapperC", value = {
		@Result(column = "user_id_", property = "userId", jdbcType = JdbcType.BIGINT),	
		@Result(column = "user_name_", property = "userName", jdbcType = JdbcType.VARCHAR),	
		@Result(column = "user_account_", property = "userAccount", jdbcType = JdbcType.VARCHAR),	
		@Result(column = "user_phone_", property = "userPhone", jdbcType = JdbcType.VARCHAR),	
		@Result(column = "user_email_", property = "userEmail", jdbcType = JdbcType.VARCHAR),	
		@Result(column = "user_password_", property = "password", jdbcType = JdbcType.VARCHAR),	
		@Result(column = "user_real_name_", property = "userRealName", jdbcType = JdbcType.VARCHAR),	
		@Result(column = "user_sex_", property = "userSex", jdbcType = JdbcType.VARCHAR),	
		@Result(column = "user_birthday_", property = "userBirthday", jdbcType = JdbcType.VARCHAR)	
	})
	UserModel selectOne(Long id);
	
	@Select("select * from user_info where user_name_ = #{userName}")
	@ResultMap("mapperC")
	UserModel selectOneByName(String userName);
//	用户所有信息
	@Select("select * from user_info order by user_id_ desc")
	@ResultMap("mapperC")
	List<UserModel> selectAll();
	//添加用户
	@InsertProvider(type = MapperCProvider.class, method = "insertUser")
	int insertUser(UserModel user);
	//跟新用户数据
	@UpdateProvider(type = MapperCProvider.class, method = "updateUser")
	int updateUser(UserModel user);
	//跟新密码
	@Update({
		"update user_info set user_password_ = #{password} where user_id_ = #{userId}"
	})
	int updateUserPassword(String password, Long userId);
}
