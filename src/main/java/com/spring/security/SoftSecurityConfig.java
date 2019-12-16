/**
 * 
 */
package com.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ajax
 *
 */
@Configuration
public class SoftSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.anonymous().and().cors().disable().csrf().disable();
//		http.formLogin()
//			.loginPage("/login")
//			.defaultSuccessUrl("/indexHome")
//			.and()
//			.logout()
//			.logoutUrl("/logout")
//			.logoutSuccessUrl("/login")
//			.and()
//			.authorizeRequests()
//			.antMatchers("/login").permitAll()
//			.antMatchers("/logout").permitAll()
//			.anyRequest()
//			.authenticated();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
		String[] str = new String[] {"/css/**","/js/**","/images/**","/layui.js","/font/**","/lay/**", "/favicon.ico"};
        web.ignoring().antMatchers(str);
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("soft").password(new BCryptPasswordEncoder().encode("soft1122")).roles("USER");
	}
}

