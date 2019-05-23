package com.huylam98it.springblog.model;

import java.util.ArrayList;
import java.util.List;

public class ChartModel{

    private List<String> name;
    private List<Integer> data;
    private List<String> backgroundColor;
    private final String hoverBorderColor="rgba(234, 236, 244, 1)";

    public ChartModel(){
        name=new ArrayList<>();
        data=new ArrayList<>();
        backgroundColor=new ArrayList<>();
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public List<String> getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(List<String> backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getHoverBorderColor() {
        return hoverBorderColor;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}
