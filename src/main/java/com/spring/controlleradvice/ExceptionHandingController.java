/**
 * 
 */
package com.spring.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.exception.SpringRuntimeException;

/**
 * @author administrator
 *
 */
@ControllerAdvice
public class ExceptionHandingController {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandingController.class);
	
	private final static String MESSAGE = "message";
	
	private final static String DEFAULT_MESSAGE = "系统错误,请联系管理员";
	
	private final static String URL = "url";
	
	@ExceptionHandler(SpringRuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String,Object> handleError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		log.error("1", ex);
		Map<String, Object> result = new HashMap<>();
		result.put(MESSAGE, ex.getMessage() == null ? DEFAULT_MESSAGE : ex.getMessage());
		result.put(URL, request.getRemoteAddr());
		return result;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, Object> handleException(HttpServletRequest request, HttpServletResponse response, Exception ex){
		log.error("1", ex);
		Map<String, Object> result = new HashMap<>();
		result.put(MESSAGE, ex.getMessage() == null ? DEFAULT_MESSAGE : ex.getMessage());
		result.put(URL, request.getRemoteAddr());
		return result;
	}
	
	

}
