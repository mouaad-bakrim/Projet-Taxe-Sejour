package com.example.demo.service;


import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.dao.TauxTaxeTrimestrielDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TauxTaxeTrimestrielService {

@Autowired

    private TauxTaxeTrimestrielDao taxeTrimestrielDao;

    public TauxTaxeTrimestriel findByCategorieLocaleSejourCode(String code) {
        return taxeTrimestrielDao.findByCategorieLocaleSejourCode(code);
    }
}
