package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huc on 2017/8/28.
 */
public class TimeUtils {


    public static String getFormatTimeStamp(String format,Long time){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(time*1000));
    }
    
    public static long getFormatDate(String format,String date) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	return sdf.parse(date).getTime()/1000;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getFormatTimeStamp("yyyy-MM-dd",1503890654l));
        System.out.println(getFormatDate("yyyy-MM-dd hh:mm:ss","2017-08-29 12:55:22"));
    }
}
