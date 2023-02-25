package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class TaxeAnuelle {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private int Annee ;
    @ManyToOne
    private  Redevable redevable ;

    @ManyToOne
    private  CategorieLocaleSejour categorieLocaleSejour ;

    @ManyToOne
    private Locale locale;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int annee) {
        Annee = annee;
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

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }



}
