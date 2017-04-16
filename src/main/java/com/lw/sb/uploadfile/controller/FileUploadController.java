package com.lw.sb.uploadfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by lw on 2017/4/16.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        System.out.println("进入到upload方法");
        return "upload";
    }


    /**
     * 文件上传的具体实现
     */

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败" ;
        }
        return "上传成功";
    }


}
