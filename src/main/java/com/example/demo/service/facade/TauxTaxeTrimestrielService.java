package com.example.demo.service.facade;

import com.example.demo.bean.TauxTaxeTrimestriel;

import java.time.LocalDateTime;
import java.util.List;

public interface TauxTaxeTrimestrielService {
    TauxTaxeTrimestriel findByCategorieLocaleCodeAndReference(String code, String reference);

    TauxTaxeTrimestriel findByCategorieLocaleCode(String code);

    TauxTaxeTrimestriel findByReference(String reference);

    int deleteByCategorieLocaleCode(String code);

    List<TauxTaxeTrimestriel> findAll();

    int save(TauxTaxeTrimestriel tauxTaxeTrimestriel);


}
