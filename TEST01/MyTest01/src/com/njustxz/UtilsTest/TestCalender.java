package com.njustxz.UtilsTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalender {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        System.out.println(date);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        System.out.println(c2.get(Calendar.YEAR));
        System.out.println(c2.get(Calendar.MONTH));
        System.out.println(c2.get(Calendar.DATE));
        c2.set(2020,4,23,13,50,25);
        System.out.println(c2.getTime());
        c2.add(Calendar.YEAR,1);
        c2.add(Calendar.MONTH,2);
        c2.add(Calendar.DATE,1);
        System.out.println(c2.getTime());


        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(c2.getTime()));

    }
}
