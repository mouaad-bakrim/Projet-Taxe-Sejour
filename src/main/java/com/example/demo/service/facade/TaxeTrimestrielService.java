package com.example.demo.service.facade;

import com.example.demo.bean.TaxeTrimestriel;

import java.time.LocalDateTime;
import java.util.List;

public interface TaxeTrimestrielService {
    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);

    TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre, int annee);


    int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);
    int save(int trimest, String refLocale, double annee, LocalDateTime datePresentation);


    List<TaxeTrimestriel> findAll();


}
