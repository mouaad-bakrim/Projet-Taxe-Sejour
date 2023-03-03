package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class TaxeAnuelle {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private int annee;
    @ManyToOne
    private Redevable redevable;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Locale locale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        annee = annee;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public Categorie getCategorieLocaleSejour() {
        return categorie;
    }

    public void setCategorieLocaleSejour(Categorie categorie) {
        this.categorie = categorie;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
