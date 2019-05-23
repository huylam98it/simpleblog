package com.huylam98it.springblog.controller;

import com.huylam98it.springblog.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping(value = "/upload")
    public ResponseEntity<Map<String,String>> upload(@RequestParam("file")MultipartFile img, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        System.out.println("da vao day");
        Map<String,String> res=new HashMap<String,String>();
        try {
            String path=uploadService.upload(img);
            res.put("link",path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
