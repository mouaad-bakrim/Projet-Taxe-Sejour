package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class NotificationBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int annee;
    private int numero;
    private int trimestre;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Locale locale;
    @OneToOne
    private NotificationLocalBean notificationLocalBean;


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
}
