package com.huylam98it.springblog.service;

import com.huylam98it.springblog.dao.ChartDao;
import com.huylam98it.springblog.entity.ChartEntity;
import com.huylam98it.springblog.model.ChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartService {

    @Autowired
    private ChartDao chartDao;
    private final String[] color=new String[]{"#4e73df","#1cc88a","#36b9cc","#116568","#c9ba4a","#c9854a"};

    public ChartModel getChartModel(){
        int i=0;
        ChartModel model=new ChartModel();
        List<ChartEntity> chartEntities=chartDao.findAll();
        for(ChartEntity ct:chartEntities){
            model.getName().add(ct.getName());
            model.getData().add(ct.getViews());
            model.getBackgroundColor().add(color[i]);
            i++;
        }
        return model;
    }

}
