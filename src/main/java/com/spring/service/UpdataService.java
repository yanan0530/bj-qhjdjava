package com.spring.service;

import com.spring.model.GoodsModel;

import java.util.List;

public interface UpdataService {
    void updata(List<GoodsModel> goodsModelList);
    void updataById(GoodsModel goodsModel);
    void add(GoodsModel goodsModel);
    void del(int id);
    void updateTimeById(int id,int senddate);
}
