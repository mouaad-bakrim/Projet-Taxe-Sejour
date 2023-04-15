package com.example.demo.service.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


public class DateUtil {


    public static LocalDate constructLocalDateTime(int trimestre, int annee) {
        LocalDate dateTime;
        if (trimestre == 1) {
            dateTime = LocalDate.of(annee, Month.MARCH, 31);
        } else if (trimestre == 2) {
            dateTime = LocalDate.of(annee, Month.JUNE, 30);
        } else if (trimestre == 3) {
            dateTime = LocalDate.of(annee, Month.SEPTEMBER, 30);
        } else {
            dateTime = LocalDate.of(annee, Month.DECEMBER, 31);
        }
        return dateTime;
    }


    public static int calculateNbrMoisRetard(int trimestre, int annee, LocalDate datePresentation) {
        LocalDate localDateTime = DateUtil.constructLocalDateTime(trimestre, annee);
        Period period = Period.between(localDateTime.withDayOfMonth(1), datePresentation.withDayOfMonth(1));
        int months = period.getYears() * 12 + period.getMonths();
        if (months < 0) {
            return 0;
        } else {
            return months;
        }


    }
}
