package com.example.demo.service;


import com.example.demo.bean.CategorieLocaleSejour;
import com.example.demo.dao.CategorieLocaleSejourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieLocaleSejourService  {
    @Autowired
   private CategorieLocaleSejourDao categorieLocaleSejourDao;
    public int save(CategorieLocaleSejour categorieLocaleSejour){
        if(findByCode(categorieLocaleSejour.getCode()) !=null){
            return -1;
        }else {
            categorieLocaleSejourDao.save(categorieLocaleSejour);
            return 1;
        }
    }


    public CategorieLocaleSejour findByCode(int code) {
        return categorieLocaleSejourDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return categorieLocaleSejourDao.deleteByCode(code);
    }
}
