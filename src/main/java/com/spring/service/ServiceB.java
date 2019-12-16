/**
 * 
 */
package com.spring.service;

import java.util.List;

import com.spring.model.ArcTypeModel;

/**
 * @author Administrator
 *
 */
public interface ServiceB {
	
//	void update();
	
	List<?> list();
	
	List<?> printList();
	
	List<?> printByIds(Long... ids);

	List<?> printByPjbh(Long... ids);
	ArcTypeModel selectOneByNumber(String number);

}
