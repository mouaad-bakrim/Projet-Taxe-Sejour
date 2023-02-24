package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    @ManyToOne
    private  CategorieLocaleSejour categorieLocaleSejour ;








    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
