package com.example.demo.service;

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
}
