package com.spring.mapper;

import com.spring.model.GoodsModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MapperArctiny {
    @Insert("insert into dede_arctiny(typeid,channel,mid,senddate) VALUES(#{typeid},18,1,#{senddate})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int  add(GoodsModel goodsModel);

    @Update("update dede_arctiny set  typeid=#{typeid} where id=#{id}")
    void update(GoodsModel goodsModel);

    @Delete("delete from dede_arctiny where id=#{id}")
    void del(int id);


    @Update("update dede_arctiny set  senddate=#{senddate} where id=#{id}")
    void updateTime(int id,int senddate);
}
