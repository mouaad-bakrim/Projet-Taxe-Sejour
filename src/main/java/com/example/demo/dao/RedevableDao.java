package com.example.demo.dao;

import com.example.demo.bean.Redevable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedevableDao extends JpaRepository<Redevable, Long> {
    Redevable findByCin(String cin);


    int deleteByCin(String cin);

}
