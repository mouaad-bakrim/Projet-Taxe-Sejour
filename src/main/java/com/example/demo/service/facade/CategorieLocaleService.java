package com.example.demo.service.facade;

import com.example.demo.bean.CategorieLocale;

public interface CategorieLocaleService  {
    CategorieLocale findByCode(String code);

    int deleteByCode(String code);
    int save(CategorieLocale categorieLocale);
}
