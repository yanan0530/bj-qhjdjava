package com.spring.mapper;

import com.spring.model.GoodsModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MapperAddon18 {
    @Select("insert into dede_addon18(aid,typeid,mz,gg,jdpj,pjbh,articlemain,pinming,nf,isepq) values(#{id},#{typeid},#{mz},#{gg},#{jdpj},#{pjbh},#{articlemain},#{pinming},#{nf},#{isepq})")
    void add(GoodsModel goodsModel);

    @Update("UPDATE dede_addon18 set typeid=#{typeid},mz=#{mz},gg=#{gg},jdpj=#{jdpj},pjbh=#{pjbh},articlemain=#{articlemain},pinming=#{pinming},nf=#{nf},isepq=#{isepq} WHERE aid=#{id}")
    void updata(GoodsModel goodsModel);

    @Update("update dede_addon18 set  senddate=#{senddate} where id=#{id}")
    void updateTime(int id,int senddate);



    @Select("Select aid as id,typeid,mz,gg,jdpj,pjbh,articlemain,pinming,nf,isepq from dede_addon18 order by aid desc")
    List<GoodsModel> list();


    @Select("Select aid as id,typeid,mz,gg,jdpj,pjbh,articlemain,pinming,nf,isepq from dede_addon18 where pjbh like #{pjbhCont} order by aid desc")
    List<GoodsModel> listSearch(String pjbhCont);
    //查询编号
    @Select("SELECT * from  dede_addon18 where pjbh like '%#{search}%' ")
    List<GoodsModel> searchPjbh(int search);
    //删除
    @Delete("delete from dede_addon18 where aid=#{id}")
    void del(int id);
}
