package com.example.demo.service;


import com.example.demo.bean.CategorieLocaleSejour;
import com.example.demo.dao.CategorieLocaleSejourDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieLocaleSejourService  {
    @Autowired
    private CategorieLocaleSejourDao categorieLocaleSejourDao;
    public int save(CategorieLocaleSejour categorieLocaleSejour){
        if(findByCode(CategorieLocaleSejour.getCode()) !=null){
            return -1;
        }else {
            categorieLocaleSejourDao.save(categorieLocaleSejour);
            return 1;
        }
    }


    public CategorieLocaleSejour findByCode(String code) {
        return categorieLocaleSejourDao.findByCode(code);
    }
     @Transactional
    public int deleteByCode(String code) {
        return categorieLocaleSejourDao.deleteByCode(code);
    }
}
