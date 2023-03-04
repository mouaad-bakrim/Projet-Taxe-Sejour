package com.example.demo.service;


import com.example.demo.bean.Categorie;
import com.example.demo.dao.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategorieService {
    @Autowired
    private CategorieDao categorieDao;

    public static void main(String[] args) {
        ArrayList Categorie = new ArrayList();
        Categorie.add("hotel");
        Categorie.add("Residances Meublées");
        Categorie.add("clubs privé");
        Categorie.add("oberge");


    }


    public Categorie findByCode(String code) {
        return categorieDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return categorieDao.deleteByCode(code);
    }
}
