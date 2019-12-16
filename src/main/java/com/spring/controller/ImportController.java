package com.spring.controller;

import com.spring.model.GoodsModel;
import com.spring.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.*;

@RestController
public class ImportController {
    @Autowired
    private ImportService importService;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public List<GoodsModel> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return null;
        }
        InputStream inputStream = file.getInputStream();
        List<GoodsModel> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();
        return list;
    }


}
