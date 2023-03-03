package com.example.demo.service;

import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.dao.TaxeTrimestrielDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeTrimestrielService {

    @Autowired
    private TaxeTrimestrielDao taxeTrimestrielDao;

    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielDao.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }

    public TaxeTrimestriel findByLocaleRefAndTrimestre(String ref, int trimestre) {
        return taxeTrimestrielDao.findByLocaleRefAndTrimestre(ref, trimestre);
    }

    public int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielDao.deleteByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }
    public List<TaxeTrimestriel> findAll() {
        return taxeTrimestrielDao.findAll();
    }
}
