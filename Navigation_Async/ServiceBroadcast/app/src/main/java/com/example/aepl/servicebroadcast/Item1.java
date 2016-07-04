package com.example.aepl.servicebroadcast;

import java.util.ArrayList;

/**
 * Created by aepl on 28/6/16.
 */
public class Item1 {
    ArrayList<Cities> City;
    String stateName;
    String cityName;
    int cityId;
    int stateId;
    int totalCount;
    public Item1(){
        City = new ArrayList<Cities>();

    }
    public int getCityId(){
        return this.cityId;
    }
    public int getStateId(){
        return this.stateId;
    }
    public int getTotalCount(){
        return this.totalCount;
    }
    public String getStateName(){
        return this.stateName;
    }
    public String getCityName(){
        return this.cityName;
    }
    public ArrayList<Cities> getCity(){
        return this.City;
    }
    public void setCity(Cities C){
        this.City.add(C);
    }
    public void setStateName(String stateName){
        this.stateName= stateName;
    }
    public void setCityName (String cityName){
        this.cityName = cityName;
    }
    public void setCityId(int cityId){
        this.cityId = cityId;
    }
    public void setStateId(int stateId){
        this.stateId = stateId;
    }
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }
}
