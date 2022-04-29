package com.itproger.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoffeeAdditive
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String additiveName;
    private double additivePrice;

    public CoffeeAdditive(String additiveName, double additivePrice) {
        this.additiveName = additiveName;
        this.additivePrice = additivePrice;
    }

    public CoffeeAdditive()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdditiveName() {
        return additiveName;
    }

    public void setAdditiveName(String additiveName) {
        this.additiveName = additiveName;
    }

    public double getAdditivePrice() {
        return additivePrice;
    }

    public void setAdditivePrice(double additivePrice) {
        this.additivePrice = additivePrice;
    }
}
