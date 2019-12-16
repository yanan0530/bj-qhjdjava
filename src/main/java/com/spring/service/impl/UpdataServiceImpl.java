package com.spring.service.impl;

import com.spring.mapper.MapperAddon18;
import com.spring.mapper.MapperArchives;
import com.spring.mapper.MapperArctiny;
import com.spring.model.GoodsModel;
import com.spring.service.UpdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UpdataServiceImpl implements UpdataService {
    @Autowired
    MapperArctiny mapperArctiny;
    @Autowired
    MapperArchives mapperArchives;

    @Autowired
    MapperAddon18 mapperAddon18;
    @Override
    public void updata(List<GoodsModel> goodsModelList) {
        for (int i=0;i<goodsModelList.size();i++){
            mapperArctiny.add(goodsModelList.get(i));
            if(goodsModelList.get(i).getId() != 0 ){
                mapperArchives.add(goodsModelList.get(i));
                mapperAddon18.add(goodsModelList.get(i));
            }
        }
    }

    @Override
    public void del(int id) {
        mapperArctiny.del(id);
        mapperArchives.del(id);
        mapperAddon18.del(id);
    }

    @Override
    public void add(GoodsModel goodsModel) {
        mapperArctiny.add(goodsModel);
        if(goodsModel.getId() != 0 ){
            mapperArchives.add(goodsModel);
            mapperAddon18.add(goodsModel);
        }
    }

    @Override
    public void updataById(GoodsModel goodsModel) {
        if(goodsModel.getId() !=0){
           mapperArctiny.update(goodsModel);
           mapperArchives.update(goodsModel);
           mapperAddon18.updata(goodsModel);
        }
    }
    @Override
    public void updateTimeById(int id,int senddate) {
        mapperArctiny.updateTime(id,senddate);
        mapperArchives.updateTime(id,senddate);
    }

}
