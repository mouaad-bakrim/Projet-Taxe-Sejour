package com.example.demo.service.util;

import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.service.facade.TaxeTrimestrielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;

@Service
public class DateUtile {

    @Autowired
    private TaxeTrimestrielService taxeTrimestrielService;

    TaxeTrimestriel taxeTrimestriel = new TaxeTrimestriel() ;
    public LocalDateTime localedate(int trimestre, int annee) {


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
