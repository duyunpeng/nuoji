package com.test;

import chess.core.util.CoreDateUtils;

import java.util.Date;

/**
 * Created by yjh on 2016/8/3.
 */
public class Test {

    @org.testng.annotations.Test
    public void testDate() {
        Date date = new Date();
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        System.out.println(CoreDateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
        Date date1 = new Date();
        date1.setHours(23);
        date1.setMinutes(59);
        date1.setSeconds(59);
        System.out.println(CoreDateUtils.formatDate(date1, "yyyy-MM-dd HH:mm:ss"));
    }

}
