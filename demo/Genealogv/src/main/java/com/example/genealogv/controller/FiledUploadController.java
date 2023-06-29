package com.example.genealogv.controller;
//上传文件
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@Api("上传文件管理")
@RequestMapping("upload")
public class FiledUploadController {
    @ApiOperation("上传文件")
    @PostMapping("/upload")

    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
    System.out.println(nickname);
    //获取图片原始名称
    System.out.println(photo.getOriginalFilename());
    //取文件类型
    System.out.println(photo.getContentType());
    //System.out.println(System.getProperty("user.dir"));

    String path = request.getServletContext().getRealPath("/upload/");
    System.out.println(path);

    saveFile(photo,path);
    return "上传成功!";
}
    public void saveFile(MultipartFile photo,String path) throws IOException {
        //判断存储的目录是否存着钱，如果不存在则创建
        File dir = new File(path);
        if(!dir.exists()){
            //创建目录
            dir.mkdir();
        }
        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
