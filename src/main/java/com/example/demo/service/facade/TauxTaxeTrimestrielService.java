package com.example.demo.service.facade;

import com.example.demo.bean.Locale;
import com.example.demo.bean.TauxTaxeTrimestriel;

import java.time.LocalDateTime;
import java.util.List;

public interface TauxTaxeTrimestrielService {
    TauxTaxeTrimestriel findByCategorieLocaleCodeAndReference(String code , String reference) ;

    TauxTaxeTrimestriel findByCategorieLocaleCode (String code);

    TauxTaxeTrimestriel findByReference(String reference);
    List<TauxTaxeTrimestriel> findAll();

    int deleteByCategorieLocaleCode (String code);
      int save (TauxTaxeTrimestriel tauxTaxeTrimestriel );
    int deleteById(Long id);
    TauxTaxeTrimestriel findById(Long id);

    int update(TauxTaxeTrimestriel tauxTaxeTrimestriel );

}
