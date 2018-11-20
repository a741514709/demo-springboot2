package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by YF-20170911 on 2018/11/19.
 */
public class CommonConvertor {


    //格式化日期
    public  static Date StringToDate(String dateStr) throws ParseException {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(dateStr);
    }

    //获取未来或之前多少天
    public static  Date getCustomeDate(int day){

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,day);
        return calendar.getTime();

    }
}


