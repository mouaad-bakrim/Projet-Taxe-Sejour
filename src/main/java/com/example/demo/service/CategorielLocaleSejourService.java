package com.example.demo.service;


import com.example.demo.bean.CategorieLocaleSejour;
import com.example.demo.dao.CategorielLocaleSejourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorielLocaleSejourService{
    @Autowired
    CategorielLocaleSejourDao categorielLocaleSejourDao ;

    public CategorieLocaleSejour findByCode(int code) {
        return categorielLocaleSejourDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return categorielLocaleSejourDao.deleteByCode(code);
    }
    public int save(CategorieLocale categorieLocale) {
        if (findBycode(categorieLocaleBean.getCode()) != null) {
            return -1;
        } else {
            categorielLocaleSejourDao.save(categorieLocaleBean);
            return 1;
        }
    }
