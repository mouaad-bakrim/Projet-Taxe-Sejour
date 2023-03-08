package com.example.demo.service.impl;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.dao.TauxTaxeTrimestrielDao;
import com.example.demo.service.facade.TauxTaxeTrimestrielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TauxTaxeTrimestrielServiceImpl implements TauxTaxeTrimestrielService {

    @Autowired

    private TauxTaxeTrimestrielDao tauxTaxeTrimestrielDao;

    @Autowired
    private CategorieLocaleServiceImpl categorieLocaleService;




    public TauxTaxeTrimestriel findByCategorieCodeAndDateBetween(String code, LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielDao.findByCategorieLocaleCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }



    public int deleteByCategorieCodeAndDateBetween(String code, LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielDao.deleteByCategorieLocaleCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }


    public TauxTaxeTrimestriel findByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielDao.findByCategorieLocaleCode(code);
    }

    public int deleteByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielDao.deleteByCategorieLocaleCode(code);
    }

    public  int save (TauxTaxeTrimestriel tauxTaxeTrimestriel ){
        CategorieLocale  categorieLocale=new CategorieLocale();
        if ( findByCategorieLocaleCode(categorieLocale.getCode()) !=null){
            return -1;}
        else{
            tauxTaxeTrimestrielDao.save(tauxTaxeTrimestriel);
            return 1;
        }

    }
}


