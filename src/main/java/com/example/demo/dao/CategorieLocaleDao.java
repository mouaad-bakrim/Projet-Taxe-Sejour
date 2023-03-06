package com.example.demo.dao;


import com.example.demo.bean.CategorieLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieLocaleDao extends JpaRepository<CategorieLocale, Long> {
    CategorieLocale findByCode(String code);

    int deleteByCode(String code);
}
