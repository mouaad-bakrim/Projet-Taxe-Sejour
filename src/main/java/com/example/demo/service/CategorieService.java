package com.example.demo.service;


import com.example.demo.bean.Categorie;
import com.example.demo.dao.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    @Autowired
    private CategorieDao categorieDao;

    public int save(Categorie categorie) {
        if (findByCode(categorie.getCode()) != null) {
            return -1;
        } else {
            categorieDao.save(categorie);
            return 1;
        }
    }


    public Categorie findByCode(String code) {
        return categorieDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return categorieDao.deleteByCode(code);
    }
}
