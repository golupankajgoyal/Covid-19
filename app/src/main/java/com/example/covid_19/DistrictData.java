package com.example.covid_19;

public class DistrictData {
    private int mTotalCases;
    private String mDistrictName=null;

    public DistrictData(int totalCases,String districtName){
        mTotalCases=totalCases;
        mDistrictName=districtName;
    }

    public int getmTotalCases(){
        return mTotalCases;
    }

    public String getmDistrictName(){
        return mDistrictName;
    }
}
