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
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Locale locale;
    @OneToOne
    private NotificationLocal notificationLocal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public NotificationLocal getNotificationLocalBean() {
        return notificationLocal;
    }

    public void setNotificationLocalBean(NotificationLocal notificationLocal) {
        this.notificationLocal = notificationLocal;
    }
}
