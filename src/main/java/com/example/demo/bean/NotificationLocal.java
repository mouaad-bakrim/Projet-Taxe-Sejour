package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class NotificationLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int annee;
    private int numero;
    private int trimestre;
    @ManyToOne
    private Locale local;
    @ManyToOne
    private Redevable redevable;


    private Double mantantEstimation;

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locale getLocal() {
        return local;
    }

    public void setLocal(Locale local) {
        this.local = local;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }



    public Double getMantantEstimation() {
        return mantantEstimation;
    }

    public void setMantantEstimation(Double mantantEstimation) {
        this.mantantEstimation = mantantEstimation;
    }
}
