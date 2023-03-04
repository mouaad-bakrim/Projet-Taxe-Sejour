package com.example.demo.service;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.dao.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    @Autowired
    private CategorieDao categorieDao;

    public int save(CategorieLocale categorieLocale) {
        if (findByCode(categorieLocale.getCode()) != null) {
            return -1;
        } else {
            categorieDao.save(categorieLocale);
            return 1;
        }
    }


    public CategorieLocale findByCode(String code) {
        return categorieDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return categorieDao.deleteByCode(code);
    }
}
