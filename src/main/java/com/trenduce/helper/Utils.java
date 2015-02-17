package com.trenduce.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prafulmantale on 2/14/15.
 */
public class Utils {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private Utils(){

    }


    public static String getFormattedCurrentTime(){

        String formattedTime = "";


        formattedTime = dateFormat.format(new Date());

        return formattedTime;
    }
}
