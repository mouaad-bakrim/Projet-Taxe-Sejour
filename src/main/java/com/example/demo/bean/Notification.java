package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int annee;
    private int numero;
    private int trimestre;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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




}
