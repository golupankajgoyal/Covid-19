package com.example.covid_19;

public class IndiaData {

    private int cases;
    private int imageResourceId;

    public IndiaData(int casesCount,int imageId){
        cases=casesCount;
        imageResourceId=imageId;
    }

    public int getCases(){
        return cases;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }
}
