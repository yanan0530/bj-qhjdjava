package com.spring.service;
import com.spring.model.GoodsModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class ImportService {
    /**
     * 处理上传的文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public List<GoodsModel> getBankListByExcel(InputStream in, String fileName) throws Exception {
        List<GoodsModel> list = new ArrayList<>();

        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                break;
            }
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                GoodsModel goodsModel = new GoodsModel();
                goodsModel.setPinming(row.getCell(0).getStringCellValue());
                int typeid;
                switch (row.getCell(1).getStringCellValue().trim()) {
                    case "纸币":
                        typeid = 7;
                        break;
                    case "银元":
                        typeid = 8;
                        break;
                    case "邮票":
                        typeid = 9;
                        break;
                    case "古代币":
                        typeid = 10;
                        break;
                    case "金银纪念币":
                        typeid = 11;
                        break;
                    case "纪念币":
                        typeid = 36;
                        break;
                    default:
                        typeid = 35;
                        break;
                }
                goodsModel.setTypeid(typeid);
                goodsModel.setMz(row.getCell(2).getStringCellValue());
                goodsModel.setNf(row.getCell(3).getStringCellValue());
                goodsModel.setGg(row.getCell(4).getStringCellValue());
                goodsModel.setJdpj(row.getCell(5).getStringCellValue());
                goodsModel.setPjbh("QHJD-"+row.getCell(6).getStringCellValue());
                String art="<img src='http://image.bj-qhjd.com/"+row.getCell(6).getStringCellValue()+".jpg' width='100%' /><img src='http://image.bj-qhjd.com/"+row.getCell(6).getStringCellValue()+"B.jpg' width='100%' />";
                goodsModel.setArticlemain(art);
                String img="http://image.bj-qhjd.com/"+row.getCell(6).getStringCellValue()+".jpg";
                goodsModel.setImg(img);
                Long time=System.currentTimeMillis()/1000;
                goodsModel.setSenddate(time);
                goodsModel.setIsepq(row.getCell(7).getStringCellValue());
                list.add(goodsModel);
            }
        }
        work.close();
        return list;
    }

    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }

}
