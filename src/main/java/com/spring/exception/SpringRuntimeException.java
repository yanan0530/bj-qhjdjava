/**
 * 
 */
package com.spring.exception;

/**
 * @author WYY
 *
 */
public class SpringRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SpringRuntimeException(String message){
		super(message);
	}

}
