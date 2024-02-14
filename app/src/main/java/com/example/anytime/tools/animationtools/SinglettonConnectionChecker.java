package com.example.anytime.tools.animationtools;

import android.content.Context;
import android.util.Log;

import com.example.anytime.pages.CheckLoginForBtnConnection;

public class SinglettonConnectionChecker {

    private static SinglettonConnectionChecker instance;

    CheckLoginForBtnConnection checkLoginForBtnConnection = CheckLoginForBtnConnection.NOTLOGIN;



    private SinglettonConnectionChecker(){

    }

    public static synchronized SinglettonConnectionChecker getInstance(){
        if(instance == null){
            instance = new SinglettonConnectionChecker();
        }
        return instance;
    }

    public void setSinglettonConnectionChecker(CheckLoginForBtnConnection state){

        checkLoginForBtnConnection = state;

        Log.d("26 STATE : ", String.valueOf(checkLoginForBtnConnection));

    }

    public CheckLoginForBtnConnection getSinglettonConnectionChecker(){
        Log.d("36 Singlett", String.valueOf(checkLoginForBtnConnection));
        return checkLoginForBtnConnection;
    }

}
