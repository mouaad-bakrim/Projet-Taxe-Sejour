package com.example.demo.service;

import com.example.demo.bean.CategorieLocaleSejour;
import com.example.demo.bean.Locale;
import com.example.demo.bean.TaxeSejourTrimestriel;
import com.example.demo.dao.TaxeSejourTrimestrielDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeSejourTrimestrielService {

    @Autowired
    private TaxeSejourTrimestrielDao taxeSejourTrimestrielDao ;

    public TaxeSejourTrimestriel findByLocaleRefAndTrimestre(String ref , int trimestre) {
        return taxeSejourTrimestrielDao.findByLocaleRefAndTrimestre(ref,trimestre);
    }



    public TaxeSejourTrimestriel findByRedevableCinAndLocaleRefAndAnnee(String cin, String ref, int trimestre) {
        return taxeSejourTrimestrielDao.findByRedevableCinAndLocaleRefAndtAndTrimestre(cin, ref, trimestre);
    }

    public int DeleteByRedevableCinAndLocaleRefAndtrimestre(String cin, String ref, int trimestre) {
        return taxeSejourTrimestrielDao.DeleteByRedevableCinAndLocaleRefAndtrimestre(cin, ref, trimestre);
    }

    public List<TaxeSejourTrimestriel> findAll() {
        return taxeSejourTrimestrielDao.findAll();
    }








}
