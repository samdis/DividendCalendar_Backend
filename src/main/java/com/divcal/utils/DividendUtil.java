package com.divcal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DividendUtil {

    private final static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    private DividendUtil() {

    }

    public static Date stringToDate(String str) {
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

}
