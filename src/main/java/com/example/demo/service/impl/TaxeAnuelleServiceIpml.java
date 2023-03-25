package com.example.demo.service.impl;

import com.example.demo.bean.TaxeAnuelle;
import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.dao.TaxeAnuelleDao;
import com.example.demo.service.facade.TaxeAnuelleService;
import com.example.demo.service.util.DateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaxeAnuelleServiceIpml implements TaxeAnuelleService {
    @Autowired
    private TaxeAnuelleDao taxeAnuelleDao;
    @Autowired
    private TaxeTrimestrielServiceImpl taxeTrimestrielServiceImpl;



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

    @Override
    public int save(TaxeAnuelle taxeAnuelle) {
        return 0;
    }

    @Autowired
    TaxeTrimestrielServiceImpl TaxeTrimestrielServiceImpl ;

    public int saveTrimestre(int trimest, String refLocale, int annee, LocalDateTime datePresentation){
    return TaxeTrimestrielServiceImpl.save( trimest ,refLocale,  annee, datePresentation) ;}
    public int save(TaxeAnuelle taxeAnuelle,int trimest, String refLocale, int annee, java.time.LocalDateTime datePresentation) {
        if (findByAnnee(taxeAnuelle.getAnnee()) != null) {
            return -1;
        } else {

            saveTrimestre( 4,  refLocale,  annee, datePresentation) ;



            taxeAnuelleDao.save(taxeAnuelle);
            return 1;
        }
    }



}
