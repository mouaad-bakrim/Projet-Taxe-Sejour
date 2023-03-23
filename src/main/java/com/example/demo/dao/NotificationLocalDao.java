package com.example.demo.dao;

import com.example.demo.bean.Locale;
import com.example.demo.bean.NotificationLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationLocalDao extends JpaRepository<NotificationLocal,Long> {
    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    List<Locale> findAllLocal(@Param("annee") int annee, @Param("trimestre") int trimestre);


    List<NotificationLocal> findByRedevableCin(String cin);

    List<NotificationLocal> findByLocalRef(String ref);

    List<NotificationLocal> findByLocalDerniereAnneePayeAndLocalDernierTrimestrePaye(int DerniereAnneePaye,int DernierTrimestrePaye);

    List<NotificationLocal> findAll();

}
