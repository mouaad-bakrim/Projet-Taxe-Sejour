package com.example.demo.service.facade;

import com.example.demo.bean.TaxeTrimestriel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaxeTrimestrielService {
    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);

    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(String cin, String ref, int trimestre, int annee);

    TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre, int annee);


    int save(int trimest, int annee, String refLocale, String cin, double nombreDeNuite, LocalDate datePresentation, String tauxReference);


    TaxeTrimestriel findByCategorieLocaleLibelle(String libelle);

    int deleteById(int id);


    List<TaxeTrimestriel> findAll();

    TaxeTrimestriel findByTrimestreAndAnneeAndLocaleRef(int trimestre, int annee, String ref) ;


}
