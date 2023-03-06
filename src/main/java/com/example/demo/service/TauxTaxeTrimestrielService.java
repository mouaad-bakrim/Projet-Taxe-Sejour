package com.example.demo.service;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.dao.TauxTaxeTrimestrielDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class TauxTaxeTrimestrielService {

    @Autowired

    private TauxTaxeTrimestrielDao tauxTaxeTrimestrielDao;

    public TauxTaxeTrimestriel findByCategorieCode(String code) {
        return tauxTaxeTrimestrielDao.findByCategorieCode(code);
    }

    @Transactional
    public int deleteByCategorieCode(String code) {
        return tauxTaxeTrimestrielDao.deleteByCategorieCode(code);
    }

    public TauxTaxeTrimestriel findByCategorieCodeAndDateBetween(String code, LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielDao.findByCategorieCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }


    @Transactional
    public int deleteByCategorieCodeAndDateBetween(String code, LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielDao.deleteByCategorieCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }


}


