/**
 * 
 */
package com.spring.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author WYY
 *
 */
public class BCryptUtils {
	
	private static BCryptPasswordEncoder be = new BCryptPasswordEncoder();
	
	public static String encode(String password){
		return be.encode(password);
	}
	
	public static boolean matches(String oldPassword, String encodePassword){
		return be.matches(oldPassword, encodePassword);
	}

}
