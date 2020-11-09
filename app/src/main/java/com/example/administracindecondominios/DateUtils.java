package com.example.administracindecondominios;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    private static final SimpleDateFormat iso8601Format = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public static String formatDateTime(Context context, Date timeToFormat) {
        return iso8601Format.format(timeToFormat);

    }

    public static Date parseDateTime(Context context, String timeToParse) {

        try {
            return iso8601Format.parse(timeToParse);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
