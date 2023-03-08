package com.example.demo.service.facade;

import com.example.demo.bean.Locale;

import java.util.List;

public interface LocaleService {
    Locale findByRef(String ref);

    int deleteByRef(String ref);

    Locale findByDerniereAnneePaye(int derniereAnneePaye);


    List<Locale> findAll();
    public int save(Locale locale);
}
