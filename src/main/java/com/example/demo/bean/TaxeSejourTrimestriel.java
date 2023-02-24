package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class TaxeSejourTrimestriel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int annee;
    private int trimestre;
    private double montantParNuite;
    private double montantBase;
    private double montantRetard;
    private double montantMajoration;
    private double montantTotal;
    @ManyToOne
    private Locale locale ;
    @ManyToOne
    private Redevable redevable ;
    @ManyToOne
    private CategorieLocaleSejour categorieLocaleSejour ;

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

    public double getMontantParNuite() {
        return montantParNuite;
    }

    public void setMontantParNuite(double montantParNuite) {
        this.montantParNuite = montantParNuite;
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

    public CategorieLocaleSejour getCategorieLocaleSejour() {
        return categorieLocaleSejour;
    }

    public void setCategorieLocaleSejour(CategorieLocaleSejour categorieLocaleSejour) {
        this.categorieLocaleSejour = categorieLocaleSejour;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
