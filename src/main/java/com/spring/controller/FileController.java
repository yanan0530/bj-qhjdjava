package com.spring.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileController {
    //上传到Cpan 上传图片
    @RequestMapping("/uploadImage")
    @ResponseBody
    public Boolean uploadImage(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return false;
        }
        String filename = file.getOriginalFilename();
        String filepath="C:/images/";
        File dest = new File(filepath ,filename);
        try {
            file.transferTo(dest);
            return true;
        }catch (IOException e){
            return false;
        }
    }
}
