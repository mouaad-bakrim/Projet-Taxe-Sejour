package com.example.demo.service.facade;

import com.example.demo.bean.TaxeTrimestriel;

import java.time.LocalDateTime;
import java.util.List;

public interface TaxeTrimestrielService {
    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);

    TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre, int annee);


    int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);


    List<TaxeTrimestriel> findAll();

    int save(int trimestre, String ref, int annee, LocalDateTime datePresentation);
}
