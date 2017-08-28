package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huc on 2017/8/28.
 */
public class TimeUtils {


    public static String getCurrentTime(String format,Long time){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(time*1000));
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTime("yyyy-MM-dd",1503890654l));
    }
}
