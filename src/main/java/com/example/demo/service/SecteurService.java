package com.example.demo.service;

import com.example.demo.bean.Rue;
import com.example.demo.bean.Secteur;
import com.example.demo.dao.SecteurDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService {
    @Autowired
    private SecteurDao secteurDao;
    public List<Secteur> findAll(){
        return secteurDao.findAll();
    }
    public Secteur findByCode(Double code){
        return secteurDao.findByCode(code);
    }
    public int save(Secteur secteur) {
        if(findByCode(secteur.getCode())!=null){
            return -1;
        }else{
            secteurDao.save(secteur);
            return 1;
        }}
    @Transactional
    public int deleteByCode(Double code){
        return secteurDao.deleteByCode(code);
    }
}
