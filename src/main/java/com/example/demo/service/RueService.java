package com.example.demo.service;
import com.example.demo.bean.Quartiere;
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


}
