/**
 * 
 */
package com.spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 *
 */
@Mapper
public interface MapperA {
	
	@Select("select typename as typename from dede_arctype")
	List<Map<?, ?>> selectAll();

}
