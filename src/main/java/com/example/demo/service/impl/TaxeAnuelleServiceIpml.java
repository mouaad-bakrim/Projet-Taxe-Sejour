package com.example.demo.service.impl;

import com.example.demo.bean.TaxeAnuelle;
import com.example.demo.dao.TaxeAnuelleDao;
import com.example.demo.service.facade.TaxeAnuelleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeAnuelleServiceIpml implements TaxeAnuelleService {
    @Autowired
    private TaxeAnuelleDao taxeAnuelleDao;

    public List<TaxeAnuelle> findByRedevableCin(Long cin) {
        return taxeAnuelleDao.findByRedevableCin(cin);
    }

    public List<TaxeAnuelle> findByLocaleRef(Long ref) {
        return taxeAnuelleDao.findByLocaleRef(ref);
    }

    public TaxeAnuelle findByAnnee(int annee) {
        return taxeAnuelleDao.findByAnnee(annee);
    }

    @Transactional
    public int deleteByAnnee(int annee) {
        return taxeAnuelleDao.deleteByAnnee(annee);
    }

    public int save(TaxeAnuelle taxeAnuelle) {
        if (findByAnnee(taxeAnuelle.getAnnee()) != null) {
            return -1;
        } else {
            taxeAnuelleDao.save(taxeAnuelle);
            return 1;
        }
    }
}