package com.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.mapper.MapperAddon18;
import com.spring.mapper.MapperB;
import com.spring.mapper.MapperC;
import com.spring.model.ArcTypeModel;
import com.spring.model.GoodsModel;
import com.spring.model.UserModel;
import com.spring.service.impl.UpdataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class ControllerAdmin {
    @Autowired
    MapperB mapperB;

    //打印列表
    @GetMapping("/print")
    public List<ArcTypeModel> printModels() {
        return mapperB.selectAll();
    }

    @GetMapping("/print2")
    public PageInfo getAll(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArcTypeModel> list = mapperB.selectAll();
        PageInfo<ArcTypeModel> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Autowired
    MapperC mapperC;
    //所有用户信息
    @Autowired
    UpdataServiceImpl updataService;

    @Autowired
    MapperAddon18 mapperAddon18;

    @GetMapping("/person")
    public List<UserModel> userList() {
        return mapperC.selectAll();
    }

    @GetMapping("/repeat")
    public List<ArcTypeModel> repeat() {
        return mapperB.repeatAll();
    }


    @PostMapping("/inspectpjbh")
    public String inspectPjbh(@RequestBody List<GoodsModel> goodsModelList) {
        String doubleShops = "";
        for (int i = 0; i < goodsModelList.size(); i++) {
            String p = goodsModelList.get(i).getPjbh();
            mapperB.inspectPjbh(p);
            doubleShops = doubleShops + mapperB.inspectPjbh(p) + ',';
        }
        return doubleShops;
    }

    @PostMapping("/uplist")
    public Boolean uplist(@RequestBody List<GoodsModel> goodsModelList) {
        updataService.updata(goodsModelList);
        return true;
    }

    //添加更新藏品信息
    @PostMapping("/savecp")
    public Boolean saveCp(@RequestBody GoodsModel goodsModel) {
        updataService.updataById(goodsModel);
        return true;
    }

    @GetMapping("/goodslist")
    public List<GoodsModel> goodsModelList() {
        return mapperAddon18.list();
    }


    @GetMapping("/goodslist2")
    public PageInfo getAllgoodsModelList(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize, @RequestParam String pjbh) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsModel> list = new ArrayList<>();
        if (pjbh.length() == 0) {
            list = mapperAddon18.list();
        } else {
            String pjbhCont = "%" + pjbh + "%";
            list = mapperAddon18.listSearch(pjbhCont);
        }
        PageInfo<GoodsModel> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @GetMapping("/searchPj")
    public List<GoodsModel> searchListGoods(@RequestParam String search) {
        int a = 123;
        return mapperAddon18.searchPjbh(a);
    }

    //添加
    @PostMapping("/savegood")
    public Boolean saveGood(@RequestBody GoodsModel goodsModel) {
        String art = "<img src='http://image.bj-qhjd.com/" + goodsModel.getPjbh() + ".jpg' width='100%' /><img src='http://image.bj-qhjd.com/" + goodsModel.getPjbh() + "B.jpg' width='100%' />";
        goodsModel.setArticlemain(art);
        String img = "http://image.bj-qhjd.com/" + goodsModel.getPjbh() + ".jpg";
        goodsModel.setImg(img);
        goodsModel.setPjbh("QHJD-" + goodsModel.getPjbh());
        Long time = System.currentTimeMillis() / 1000;
        goodsModel.setSenddate(time);
        if (goodsModel.getId() == 0) {
            updataService.add(goodsModel);
        } else {
            updataService.updataById(goodsModel);
        }
        return true;
    }

    //删除
    @GetMapping("/delgood")
    public Boolean delGood(@RequestParam int id) {
        updataService.del(id);
        return true;
    }

    //根据商品Id修改时间
    @GetMapping("/changetime")
    public Boolean changeTime(@RequestParam int id, @RequestParam int senddate) {
        System.err.print(id + "++++++++++++++++" + senddate);
        updataService.updateTimeById(id,senddate);
        return true;
    }

}
