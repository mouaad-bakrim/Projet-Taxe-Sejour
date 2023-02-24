package com.example.demo.dao;

import com.example.demo.bean.TaxeSejourTrimestriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeSejourTrimestrielDao extends JpaRepository<TaxeSejourTrimestriel,Long> {
}
