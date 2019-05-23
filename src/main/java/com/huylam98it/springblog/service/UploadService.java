package com.huylam98it.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class UploadService {

    @Autowired
    private Environment env;

    public String upload(MultipartFile file) throws IOException {
        String folderUploadPath=env.getProperty("upload.folder");
        String fileName="img_"+new Date().getTime()+"."+file.getContentType().split("/")[1];
        File fileUpload=new File(folderUploadPath,fileName);
        file.transferTo(fileUpload);
        return "/images/"+fileName;
    }

}
