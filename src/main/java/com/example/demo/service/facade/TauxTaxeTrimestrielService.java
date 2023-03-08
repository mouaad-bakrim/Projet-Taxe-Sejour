package com.example.demo.service.facade;

import com.example.demo.bean.TauxTaxeTrimestriel;

import java.time.LocalDateTime;

public interface TauxTaxeTrimestrielService {
    TauxTaxeTrimestriel findByCategorieCodeAndDateBetween(String code , LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin ) ;

    TauxTaxeTrimestriel findByCategorieLocaleCode (String code);


    int deleteByCategorieCodeAndDateBetween(String code , LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin ) ;


    int deleteByCategorieLocaleCode (String code);
      int save (TauxTaxeTrimestriel tauxTaxeTrimestriel );



}
