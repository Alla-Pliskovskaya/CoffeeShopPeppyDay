package com.itproger.blog.models;

import javax.persistence.*;

@Entity

public class CoffeePrice
{
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PriceId id;

    private double coffeePrice;

    public CoffeePrice(double coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public CoffeePrice() {

    }

    public PriceId getId() {
        return id;
    }

    public void setId(PriceId id) {
        this.id = id;
    }

    public double getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(double coffeePrice) {
        this.coffeePrice = coffeePrice;
    }
}

