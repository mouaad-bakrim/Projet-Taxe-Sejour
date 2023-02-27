package com.example.demo.service.impl;

import com.example.demo.bean.Quartiere;
import com.example.demo.dao.QuartierDao;
import com.example.demo.service.facade.QuartiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartierServiceImpl implements QuartiereService {
    @Autowired
    private QuartierDao quarteirDao;

    @Override
    public Quartiere findByCode(Double code) {
        return quarteirDao.findByCode(code);
    }

    @Override
    public List<Quartiere> findAll() {
        return quarteirDao.findAll();
    }

    @Override
    public int save(Double code) {
        if(findByCode(code)==null){
            return -1;
        }

        return 1;
    }

    @Override
    public List<Quartiere> findBySecteurNom(String nom) {
        return null;
    }

    @Override
    public int deleteByCode(Double code) {
        return 0;
    }
}
