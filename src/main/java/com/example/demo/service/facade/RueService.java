package com.example.demo.service.facade;

import com.example.demo.bean.Rue;

import java.util.List;

public interface RueService {
    List<Rue> findAll();

    Rue findByCode(Double code);
    Rue findByQuartiereCode(Double code);

    int deleteByCode(Double code);
}
