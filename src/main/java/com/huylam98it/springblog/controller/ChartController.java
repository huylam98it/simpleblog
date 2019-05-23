package com.huylam98it.springblog.controller;

import com.huylam98it.springblog.model.ChartModel;
import com.huylam98it.springblog.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChartController {

    @Autowired
    private ChartService chartService;

    @PostMapping(value = "/api/chart")
    public ResponseEntity<ChartModel> getChart(){
        return new ResponseEntity<ChartModel>(chartService.getChartModel(), HttpStatus.OK);
    }

}
