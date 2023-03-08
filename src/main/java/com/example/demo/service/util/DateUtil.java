package com.example.demo.service.util;

import java.time.LocalDateTime;
import java.time.Month;

public class DateUtil {
    public LocalDateTime dateUtile(int trimestre, int annee) {


        trimestre = taxeTrimestriel.getTrimestre();
        annee = taxeTrimestriel.getAnnee();
        LocalDateTime dateTime;
        if (trimestre == 1) {
            dateTime = LocalDateTime.of(annee, Month.MARCH, 31, 0, 0);
            return dateTime;

        } else if (trimestre == 2) {
            dateTime = LocalDateTime.of(annee, Month.JUNE, 30, 0, 0);
            return dateTime;

        } else if (trimestre == 3) {
            dateTime = LocalDateTime.of(annee, Month.SEPTEMBER, 30, 0, 0);
            return dateTime;

        } else {
            dateTime = LocalDateTime.of(annee, Month.DECEMBER, 31, 0, 0);
            return dateTime;
        }
    }

}
