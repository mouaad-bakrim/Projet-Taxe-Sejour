package com.example.demo.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class TauxTaxeTrimestriel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateApplicationDebut;

    private LocalDateTime dateApplicationFin;
    private LocalDateTime date;
    private double pourcentageRetard;
    private double pourcentageMajoration;
    private double montantParNuite;

    @ManyToOne
    private CategorieLocale categorieLocale;


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDateApplicationDebut() {
        return dateApplicationDebut;
    }

    public void setDateApplicationDebut(LocalDateTime dateApplicationDebut) {
        this.dateApplicationDebut = dateApplicationDebut;
    }

    public LocalDateTime getDateApplicationFin() {
        return dateApplicationFin;
    }

    public void setDateApplicationFin(LocalDateTime dateApplicationFin) {
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

    public CategorieLocale getCategorielocale() {
        return categorieLocale;
    }

    public void setCategorielocale(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}