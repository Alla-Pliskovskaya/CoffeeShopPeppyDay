package com.itproger.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coffee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String coffeeName;

    public Coffee(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public Coffee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }
}

