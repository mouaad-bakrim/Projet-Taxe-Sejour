package com.example.demo.dao;

import com.example.demo.bean.TauxTaxeTrimestriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxTaxeTrimestrielDao extends JpaRepository<TauxTaxeTrimestriel,Long> {
}
