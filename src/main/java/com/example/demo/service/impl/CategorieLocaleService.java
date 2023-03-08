package com.example.demo.service.impl;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.dao.CategorieLocaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieLocaleService {
    @Autowired
    private CategorieLocaleDao categorieLocaleDao;

    public int save(CategorieLocale categorieLocale) {
        if (findByCode(categorieLocale.getCode()) != null) {
            return -1;
        } else {
            categorieLocaleDao.save(categorieLocale);
            return 1;
        }
    }


    public CategorieLocale findByCode(String code) {
        return categorieLocaleDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return categorieLocaleDao.deleteByCode(code);
    }
}
