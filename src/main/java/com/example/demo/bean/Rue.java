package com.example.demo.bean;

import jakarta.persistence.*;
@Entity
public class Rue {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Double code;
    private String  libelle;
    @ManyToOne
    private Quartier quartier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCode() {
        return code;
    }

    public void setCode(Double code) {
        this.code = code;
    }

    public String  getLibelle() {
        return libelle;
    }

    public void setLibelle(String  libelle) {
        this.libelle = libelle;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }
}
