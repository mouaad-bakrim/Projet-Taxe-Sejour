package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class NotificationLocale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double mantantEstimation;
    @ManyToOne
    private Locale locale;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Notification notification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMantantEstimation() {
        return mantantEstimation;
    }

    public void setMantantEstimation(Double mantantEstimation) {
        this.mantantEstimation = mantantEstimation;
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

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
