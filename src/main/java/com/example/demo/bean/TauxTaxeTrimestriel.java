package com.example.demo.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TauxTaxeTrimestriel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private Date dateApplicationDebut;
    private Date dateApplicationFin;
    private double pourcentageRetard;
    private double pourcentageMajoration;
    private double montantParNuite;
    private double montantRetard;
    private double montantMajoration;
    @OneToOne
    private CategorieLocaleSejour categorie;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public double getMontantRetard() {
        return montantRetard;
    }

    public void setMontantRetard(double montantRetard) {
        this.montantRetard = montantRetard;
    }

    public double getMontantMajoration() {
        return montantMajoration;
    }

    public void setMontantMajoration(double montantMajoration) {
        this.montantMajoration = montantMajoration;
    }

    public CategorieLocaleSejour getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieLocaleSejour categorie) {
        this.categorie = categorie;
    }
}