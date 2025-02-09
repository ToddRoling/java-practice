package com.github.toddroling.java.practice.date;

import java.util.Calendar;

public class CalendarSolutions {

    // My solution to https://www.hackerrank.com/challenges/java-date-and-time/problem
    public static String findDay(int month, int day, int year) {
        String[] weekDays = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        Calendar calendar = Calendar.getInstance();
        //noinspection MagicConstant
        calendar.set(year, month - 1, day);
        int dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDays[dayOfWeekNumber - 1];
    }
}
