package com.huylam98it.springblog.controller;

import com.huylam98it.springblog.dao.AccountDao;
import com.huylam98it.springblog.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

@Component
public class EventOnInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public Environment env;

    @Autowired
    public AccountDao accountDao;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String folderUploadPath=env.getProperty("upload.folder");
        File folderUpload=new File(folderUploadPath);
        try{
            if(folderUpload.exists()==false)
                folderUpload.mkdirs();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        Account admin=accountDao.findAccountByUsername("admin");
        if(admin==null){
            admin=new Account();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setCreated(new Date());
            accountDao.save(admin);
        }
    }
}
