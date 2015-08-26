package com.github.ichenkaihua.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenkaihua on 15-8-23.
 */
public class DateUtils {

    public static  String getCurrentTimeFromatedString(String template){
        Date date = new Date();
        return formate(date,template);

    }

    public  static  String getCurrentTimeFromatedString(){
        return getCurrentTimeFromatedString("yyyy-MM-dd-HH-mm-ss");
    }

    public static String formate(Date date,String template){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(template);
        return simpleDateFormat.format(date);
    }





}
