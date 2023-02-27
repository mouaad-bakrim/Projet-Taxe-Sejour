package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity

public class TauxTaxeTrimestriel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateApplicationDebut;
    private Date dateApplicationFin;
    private double pourcentageRetard;
    private double pourcentageMajoration;
    private double montantParNuite;
    @OneToOne
    private CategorieLocaleSejour categorie;


    public Date getDateApplicationDebut() {
        return dateApplicationDebut;
    }

    public void setDateApplicationDebut(Date dateApplicationDebut) {
        this.dateApplicationDebut = dateApplicationDebut;
    }

    public Date getDateApplicationFin() {
        return dateApplicationFin;
    }

    public void setDateApplicationFin(Date dateApplicationFin) {
        this.dateApplicationFin = dateApplicationFin;
    }

    public double getPourcentageRetard() {
        return pourcentageRetard;
    }

    public void setPourcentageRetard(double pourcentageRetard) {
        this.pourcentageRetard = pourcentageRetard;
    }

    public double getPourcentageMajoration() {
        return pourcentageMajoration;
    }

    public void setPourcentageMajoration(double pourcentageMajoration) {
        this.pourcentageMajoration = pourcentageMajoration;
    }

    public double getMontantParNuite() {
        return montantParNuite;
    }

    public void setMontantParNuite(double montantParNuite) {
        this.montantParNuite = montantParNuite;
    }

    public CategorieLocaleSejour getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieLocaleSejour categorie) {
        this.categorie = categorie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}