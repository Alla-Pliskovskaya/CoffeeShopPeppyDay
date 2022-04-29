package com.itproger.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bakery
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bakeryName;
    private double bakeryPrice;
    private int calories;

    public Bakery(String bakeryName, double bakeryPrice, int calories) {
        this.bakeryName = bakeryName;
        this.bakeryPrice = bakeryPrice;
        this.calories = calories;
    }

    public Bakery()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBakeryName() {
        return bakeryName;
    }

    public void setBakeryName(String bakeryName) {
        this.bakeryName = bakeryName;
    }

    public double getBakeryPrice() {
        return bakeryPrice;
    }

    public void setBakeryPrice(double bakeryPrice) {
        this.bakeryPrice = bakeryPrice;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
