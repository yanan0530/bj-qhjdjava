package com.spring.mapper;

import com.spring.model.GoodsModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MapperArchives {
    @Insert("insert into dede_archives(id,typeid,title,voteid,mid,channel,litpic,senddate) values(#{id},#{typeid},#{pinming},'0','1','18',#{img},#{senddate})")
    void add(GoodsModel goodsModel);

    @Update("update dede_archives set typeid=#{typeid},title=#{pinming},litpic=#{img} where id=#{id}")
    void update(GoodsModel goodsModel);

    @Delete("delete from dede_archives where id=#{id}")
    void del(int id);


    @Update("update dede_archives set senddate=#{senddate} where id=#{id}")
    void updateTime(int id,int senddate);
}
