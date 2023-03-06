package com.example.demo.service;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.dao.TauxTaxeTrimestrielDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TauxTaxeTrimestrielService {

    @Autowired

    private TauxTaxeTrimestrielDao tauxTaxeTrimestrielDao;

    @Autowired
    private CategorieLocaleService categorieLocaleService;




    public TauxTaxeTrimestriel findByCategorieCodeAndDateBetween(String code, LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielDao.findByCategorieCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }


    @Transactional
    public int deleteByCategorieCodeAndDateBetween(String code, LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielDao.deleteByCategorieCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }

    public TauxTaxeTrimestriel findByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielDao.findByCategorieLocaleCode(code);
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


