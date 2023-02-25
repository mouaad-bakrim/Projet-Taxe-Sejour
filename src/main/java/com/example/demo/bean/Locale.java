package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class Locale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private int Annee ;

    int derniereAnneePaye ;
    int dernierTrimestrePaye ;

    @ManyToOne
    private  Redevable redevable ;
    @ManyToOne
    private  CategorieLocaleSejour categorieLocaleSejour ;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }

    public int getDerniereAnneePaye() {
        return derniereAnneePaye;
    }

    public void setDerniereAnneePaye(int derniereAnneePaye) {
        this.derniereAnneePaye = derniereAnneePaye;
    }

    public int getDernierTrimestrePaye() {
        return dernierTrimestrePaye;
    }

    public void setDernierTrimistrePaye(int dernierTrimistrePaye) {
        this.dernierTrimestrePaye = dernierTrimistrePaye;
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
