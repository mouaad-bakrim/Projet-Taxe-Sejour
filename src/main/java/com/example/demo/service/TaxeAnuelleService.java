package com.example.demo.service;

import com.example.demo.bean.CategorieLocaleSejour;
import com.example.demo.bean.TaxeAnuelle;
import com.example.demo.dao.TaxeAnuelleDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeAnuelleService {
    @Autowired
    private TaxeAnuelleDao taxeAnuelleDao;
    private com.example.demo.bean.TaxeAnuelle TaxeAnuelle;

    public List<TaxeAnuelle> findByRedevableId(Long id) {
        return taxeAnuelleDao.findByRedevableId(id);
    }

    public List<TaxeAnuelle> findByCategorieLocaleSejour(Long id) {
        return taxeAnuelleDao.findByCategorieLocaleSejour(id);
    }

    public List<TaxeAnuelle> findByLocale(Long id) {
        return taxeAnuelleDao.findByLocale(id);
    }

    public TaxeAnuelle findByAnnee(int annee) {
        return taxeAnuelleDao.findByAnnee(annee);
    }
    @Transactional
    public int deleteByAnnee(int annee) {
        return taxeAnuelleDao.deleteByAnnee(annee);
    }

    public int save(TaxeAnuelle taxeAnuelle){
        if(findByAnnee(TaxeAnuelle.getAnnee()) !=null){
            return -1;
        }else {
            taxeAnuelleDao.save(TaxeAnuelle);
            return 1;
        }
    }
}
