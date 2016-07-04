package com.example.aepl.servicebroadcast;

/**
 * Created by aepl on 28/6/16.
 */
public class Cities {
    int cityId;
    String cityName;
    int totalCount;
    public void Cities(int cityId ,String cityName, int totalCount){
        this.cityId = cityId;
        this.cityName = cityName;
        this.totalCount = totalCount;

    }
    public int getCityId(){
        return this.cityId;
    }
    public int getTotalCount(){
        return this.totalCount;
    }
    public String getCityName(){
        return this.cityName;
    }
    public void setCityId(int cityId){
        this.cityId = cityId;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }
}
