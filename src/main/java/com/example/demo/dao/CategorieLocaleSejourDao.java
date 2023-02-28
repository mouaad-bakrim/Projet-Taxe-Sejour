package com.example.demo.dao;


import com.example.demo.bean.CategorieLocaleSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieLocaleSejourDao extends JpaRepository<CategorieLocaleSejour, Long> {
    CategorieLocaleSejour findByCode(String code);

    int deleteByCode(String code);
}
