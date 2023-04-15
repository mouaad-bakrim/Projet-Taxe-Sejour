package com.example.demo.service.facade;

import com.example.demo.bean.TauxTaxeAnuelle;

import java.util.List;

public interface TauxTaxeAnuelleService {
    TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(String code , String reference) ;

    TauxTaxeAnuelle findByCategorieLocaleCode (String code);

    int deleteByCategorieLocaleCode (String code);

    int save(TauxTaxeAnuelle tauxTaxeAnuelle);
    List<TauxTaxeAnuelle> findAll();
    int deleteById(int id);
    TauxTaxeAnuelle findById(Long id);
    int update(TauxTaxeAnuelle tauxTaxeAnuelle );
    TauxTaxeAnuelle findByReference(String reference);

}
