package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Local {
    @Id
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
