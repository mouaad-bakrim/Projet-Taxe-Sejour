package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NotificationLocalBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Locale local;
    private Redevable redevable;
    private Double mantantEstination;

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

    public Double getMantantEstination() {
        return mantantEstination;
    }

    public void setMantantEstination(Double mantantEstination) {
        this.mantantEstination = mantantEstination;
    }
}
