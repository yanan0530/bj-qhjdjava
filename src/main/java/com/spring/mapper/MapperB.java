/**
 *
 */
package com.spring.mapper;

import static com.spring.env.Constant.PRINT_URL;
import static com.spring.env.Constant.SUFF;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.spring.model.ArcTypeModel;

/**
 * @author Administrator
 *
 */
@Mapper
public interface MapperB {

//	@Update("UPDATE dede_arctype u JOIN ("
//			+ "SELECT "
//			+ "CONCAT('"+ PRINT_URL +"',t.id ,'"+ SUFF +"') AS url, "
//			+ "t.id AS id "
//			+ "FROM dede_arctype t"
//			+ ") r ON r.id = u.id SET u.print_url = r.url")
//	void update();

	@Select("SELECT concat('"+ PRINT_URL +"', x.typedir,'/', t.aid, '"+ SUFF +"') as print_url, "
			+ "t.mz, t.isepq, t.gg, t.jdpj, t.pinming, t.articlemain, t.nf ,t.pjbh,t.aid as id "
			+ " FROM dede_addon18 t "
			+ " LEFT JOIN dede_arctype x ON t.typeid = x.id ORDER BY t.aid DESC")
	@Results(id = "mapperB", value = {
		@Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR),
		@Result(column = "mz", property = "goodsName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "gg", property = "size", jdbcType = JdbcType.VARCHAR),
		@Result(column = "jdpj", property = "talk", jdbcType = JdbcType.VARCHAR),
		@Result(column = "pjbh", property = "num", jdbcType = JdbcType.VARCHAR),
		@Result(column = "pinming", property = "spec", jdbcType = JdbcType.VARCHAR),
		@Result(column = "articlemain", property = "img", jdbcType = JdbcType.VARCHAR),
		@Result(column = "nf", property = "year", jdbcType = JdbcType.VARCHAR),
		@Result(column = "isepq", property = "isepq", jdbcType = JdbcType.VARCHAR),
		@Result(column = "print_url", property = "printUrl", jdbcType = JdbcType.LONGVARCHAR)
	})
	List<ArcTypeModel> selectAll();

	//获取重复商品
	@Select("SELECT concat('\"+ PRINT_URL +\"', x.typedir,'/', t.aid, '\"+ SUFF +\"') as print_url, t.mz, t.isepq, t.gg, t.jdpj, t.pinming, t.articlemain, t.nf ,t.pjbh,t.aid as id\n" +
			"\t\t\t FROM dede_addon18 t LEFT JOIN dede_arctype x ON t.typeid = x.id\n" +
			"                where  t.pjbh in (select pjbh from dede_addon18 group by pjbh having count(pjbh) > 1)\n" +
			"                ORDER BY t.pjbh DESC")
	@ResultMap("mapperB")
	List<ArcTypeModel> repeatAll();
    //检查重复
//    select pjbh from dede_addon18 where pjbh in ('QHJD-19120970','QHJD-19120972')
    @Select("select pjbh from dede_addon18 where pjbh in (#{p})")
    String inspectPjbh(String p);

	@Select({
		"<script>",
		"SELECT concat('"+ PRINT_URL +"', x.typedir,'/', t.aid, '"+ SUFF +"') as print_url, "
				+ "t.mz, t.isepq, t.gg, t.jdpj, t.pinming, t.articlemain, t.nf ,t.pjbh,t.aid as id "
				+ " FROM dede_addon18 t "
				+ " LEFT JOIN dede_arctype x ON t.typeid = x.id "
				+ "WHERE t.aid IN "
				+ "<foreach collection='ids' item='id' open='(' separator=',' close=')'>"
                +	" #{id} "
                +  "</foreach>",
        "</script>"
	})
	@ResultMap("mapperB")
	List<ArcTypeModel> selectByIds(@Param("ids") Long... ids);


	//根据产品编号
	@Select({
			"<script>",
			"SELECT concat('"+ PRINT_URL +"', x.typedir,'/', t.aid, '"+ SUFF +"') as print_url, "
					+ "t.mz, t.isepq, t.gg, t.jdpj, t.pinming, t.articlemain, t.nf ,t.pjbh,t.aid as id "
					+ " FROM dede_addon18 t "
					+ " LEFT JOIN dede_arctype x ON t.typeid = x.id "
					+ "WHERE t.pjbh in"
					+ "<foreach collection='ids' item='id' open='(' separator=',' close=')'>"
					+	"'QHJD-${id}'" 
					+  "</foreach>",
			"</script>"
	})
	@ResultMap("mapperB")
	List<ArcTypeModel> selectByPjbh(@Param("ids") Long... ids);

	@Select({
		"SELECT concat('"+ PRINT_URL +"', x.typedir,'/', t.aid, '"+ SUFF +"') as print_url, "
				+ "t.mz, t.gg, t.jdpj, t.pinming, t.articlemain, t.nf ,t.pjbh,t.aid as id "
				+ " FROM dede_addon18 t "
				+ " LEFT JOIN dede_arctype x ON t.typeid = x.id "
				+ "WHERE t.pjbh like concat('%', #{number, jdbcType=VARCHAR})"
	})
	@ResultMap("mapperB")
	List<ArcTypeModel> selectOneByNumber(String number);
}
