package com.example.demo.dao;

import com.example.demo.bean.TaxeAnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxeAnuelleDao extends JpaRepository<TaxeAnuelle, Long> {



}
