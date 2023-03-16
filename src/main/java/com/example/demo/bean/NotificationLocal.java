package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class NotificationLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Locale local;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Notification notification;
    private Double mantantEstimation;

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

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Double getMantantEstimation() {
        return mantantEstimation;
    }

    public void setMantantEstimation(Double mantantEstimation) {
        this.mantantEstimation = mantantEstimation;
    }
}
