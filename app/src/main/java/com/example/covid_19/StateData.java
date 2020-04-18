package com.example.covid_19;

public class StateData {

    private int mConfirmedCases;
    private int mActiveCases;
    private int mRecoveredCases;
    private int mDeath;
    private String mStateName;

    public StateData(int confirmedCases, int activeCases, int recoveredCases, int death, String stateName){

        mConfirmedCases=confirmedCases;
        mActiveCases=activeCases;
        mRecoveredCases=recoveredCases;
        mDeath=death;
        mStateName=stateName;
    }

    public int getmConfirmedCases(){
        return mConfirmedCases;
    }

    public int getmActiveCases(){
        return  mActiveCases;
    }

    public  int getmRecoveredCases(){
        return mRecoveredCases;
    }

    public int getmDeath(){
        return mDeath;
    }

    public  String getmStateName(){
        return mStateName;
    }
}
