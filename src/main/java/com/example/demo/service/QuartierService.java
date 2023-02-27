package com.example.demo.service;

import com.example.demo.bean.Quartier;
import com.example.demo.dao.QuartierDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartierService {
    @Autowired
    public QuartierDao quartierDao;


    public Quartier findByCode(Double code) {
        return quartierDao.findByCode(code);
    }
    @Transactional
    public int deleteByCode(Double code) {
        return quartierDao.deleteByCode(code);
    }

    public List<Quartier> findAll() {
        return quartierDao.findAll();
    }

    public <S extends Quartier> S save(S entity) {
        return quartierDao.save(entity);
    }
}
