package com.example.covid_19;

public class IndiaData {

    private int cases;
    private int imageResourceId;
    private String casesTitle;

    public IndiaData(int casesCount,int imageId,String title){
        cases=casesCount;
        imageResourceId=imageId;
        casesTitle=title;
    }

    public int getCases(){
        return cases;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public String getCasesTitle(){
        return casesTitle;
    }
}
