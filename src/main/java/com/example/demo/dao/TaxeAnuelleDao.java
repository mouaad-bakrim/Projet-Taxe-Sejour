package com.example.demo.dao;

import com.example.demo.bean.TaxeAnuelle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaxeAnuelleDao extends JpaRepository<TaxeAnuelle, Long> {

    List<TaxeAnuelle> findByRedevableId(Long id);

    List<TaxeAnuelle> findByCategorieLocaleSejour(Long id);

    List<TaxeAnuelle> findByLocale(Long id);


    TaxeAnuelle findByAnnee(int annee);

    int deleteByAnnee(int annee);

}
