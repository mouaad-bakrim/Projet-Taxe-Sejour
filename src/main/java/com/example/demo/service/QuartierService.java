package com.example.demo.service;

<<<<<<< HEAD
import com.example.demo.bean.Quartiere;
=======
import com.example.demo.bean.Quartier;
>>>>>>> origin/main
import com.example.demo.dao.QuartierDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartierService {
    @Autowired
<<<<<<< HEAD
    private QuartierDao quarteirDao;


    public Quartiere findByCode(Double code) {
        return quarteirDao.findByCode(code);
    }

    public List<Quartiere> findAll() {
        return quarteirDao.findAll();
    }

    public int save(Quartiere quartiere) {
        if(findByCode(quartiere.getCode())!=null){
            return -1;
        }else{
            quarteirDao.save(quartiere);
            return 1;
        }

    }
@Transactional
    public int deleteByCode(Double code) {
        return QuartierDao.deleteByCode(code);
=======
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
>>>>>>> origin/main
    }
}
