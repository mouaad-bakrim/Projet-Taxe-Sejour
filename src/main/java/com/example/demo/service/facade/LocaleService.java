package com.example.demo.service.facade;

import com.example.demo.bean.Locale;

import java.util.List;

public interface LocaleService {
    Locale findByRef(String ref);

    int deleteByRef(String ref);

    List<Locale> findByDerniereAnneePaye(int derniereAnneePaye);
    List<Locale> findByDernierTrimestrePaye(int DernierTrimestrePaye);


    List<Locale> findAll();
    public int save(Locale locale);
}
