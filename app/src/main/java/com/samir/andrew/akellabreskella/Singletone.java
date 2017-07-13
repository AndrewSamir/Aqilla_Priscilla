package com.samir.andrew.akellabreskella;

import android.content.Context;

/**
 * Created by andre on 12-Jun-17.
 */

public class Singletone {

    private static Singletone instance;
    private String HtmlUrL;
    //no outer class can initialize this class's object
    private Singletone() {}

    public static Singletone Instance()
    {
        //if no instance is initialized yet then create new instance
        //else return stored instance
        if (instance == null)
        {
            instance = new Singletone();
        }
        return instance;
    }

    public String getHtmlUrL() {
        return HtmlUrL;
    }

    public void setHtmlUrL(String HtmlUrL) {
        this.HtmlUrL = HtmlUrL;
    }

}
