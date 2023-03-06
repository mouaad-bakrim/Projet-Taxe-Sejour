package com.example.demo.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TaxeTrimestriel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateDePresentation;
    private int annee;
    private int trimestre;
    private int NombreDeMoisRetard;
    private double nombreDeNuite;
    private double montantBase;
    private double montantRetard;
    private double montantMajoration;
    private double montantTotal;
    @ManyToOne
    private Locale locale;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private CategorieLocale categorieLocale;
    @OneToOne
    private TauxTaxeTrimestriel tauxTaxeTrimestriel;

    public LocalDateTime getDateDePresentation() {
        return dateDePresentation;
    }


    public void setDateDePresentation(LocalDateTime dateDePresentation) {
        this.dateDePresentation = dateDePresentation;
    }

    public double getNombreDeNuite() {
        return nombreDeNuite;
    }

    public void setNombreDeNuite(double nombreDeNuite) {
        this.nombreDeNuite = nombreDeNuite;
    }

    public TauxTaxeTrimestriel getTauxTaxeTrimestriel() {
        return tauxTaxeTrimestriel;
    }

    public void setTauxTaxeTrimestriel(TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        this.tauxTaxeTrimestriel = tauxTaxeTrimestriel;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }


    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public int getNombreDeMoisRetard() {
        return NombreDeMoisRetard;
    }

    public void setNombreDeMoisRetard(int nombreDeMoisRetard) {
        NombreDeMoisRetard = nombreDeMoisRetard;
    }

    public CategorieLocale getCategorieLocale() {
        return categorieLocale;
    }

    public void setCategorieLocale(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }

    public double getMontantParNuite() {
        return nombreDeNuite;
    }

    public void setMontantParNuite(double montantParNuite) {
        this.nombreDeNuite = montantParNuite;
    }

    public double getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(double montantBase) {
        this.montantBase = montantBase;
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

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public CategorieLocale getCategorieLocaleSejour() {
        return categorieLocale;
    }

    public void setCategorieLocaleSejour(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
