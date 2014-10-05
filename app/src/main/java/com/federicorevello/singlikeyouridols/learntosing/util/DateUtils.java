package com.federicorevello.singlikeyouridols.learntosing.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sebastian on 04/10/14.
 */
public class DateUtils {

    private static String TAG = "com.federicorevello.singlikeyouridols.learntosing.util.DateUtils";
    public static final String INTERNAL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String dateToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat(INTERNAL_DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static Date stringToDate(String stringDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat(INTERNAL_DATE_FORMAT);
        Date date = null;
        try {
            date = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            Log.e(TAG, e.getMessage());
        }

        return date;
    }
}
