package com.carManager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String dataFormat() {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sp.format(new Date());
    }
}
