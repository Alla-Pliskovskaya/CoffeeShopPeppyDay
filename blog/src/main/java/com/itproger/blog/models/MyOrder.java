package com.itproger.blog.models;

import javax.persistence.*;

@Entity
public class MyOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;

    private String login, coffee,volume, additive, bakery, date_time;


    public MyOrder() {

    }

    public MyOrder(String login, String coffee, String volume, String additive, String bakery, String date_time) {
        this.login = login;
        this.coffee = coffee;
        this.volume = volume;
        this.additive = additive;
        this.bakery = bakery;
        this.date_time = date_time;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long order_id) {
        this.orderId = order_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public String getBakery() {
        return bakery;
    }

    public void setBakery(String bakery) {
        this.bakery = bakery;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
