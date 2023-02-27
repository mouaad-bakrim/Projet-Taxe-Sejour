package com.example.demo.service;

<<<<<<< HEAD
import com.example.demo.bean.Quartiere;
=======
>>>>>>> origin/main
import com.example.demo.bean.Rue;
import com.example.demo.dao.RueDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RueService {
    @Autowired
    private RueDao rueDao;
<<<<<<< HEAD
    @Autowired
    private Quartiere quartier;

    public List<Rue> findAll(){

       return  rueDao.findAll();}

    public Rue findByCode(Double code){
        return rueDao.findByCode(code);
    }
    public Rue findByQuartiereCode(Double code){
        return rueDao.findByQuartiereCode(code);
    }
    public int save(Rue rue) {
        if(findByCode(rue.getCode())!=null){
            return -1;
        }else{
            rueDao.save(rue);
            return 1;
        }}
    @Transactional
    public int deleteByCode(Double code){
            return rueDao.deleteByCode(code);
        }
=======

    public Rue findByCode(Double code) {
        return rueDao.findByCode(code);
    }
    @Transactional
    public int deleteByCode(Double code) {
        return rueDao.deleteByCode(code);
    }

    public List<Rue> findByQuartierCode(Double Code) {
        return rueDao.findByQuartierCode(Code);
    }
>>>>>>> origin/main
}
