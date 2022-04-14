package com.itproger.blog.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PriceId implements Serializable
{
    private Long coffee_id;
    private Long volume_id;

    public PriceId(Long coffee_id, Long volume_id) {
        this.coffee_id = coffee_id;
        this.volume_id = volume_id;
    }

    public PriceId() {

    }

    public Long getCoffee_id() {
        return coffee_id;
    }

    public void setCoffee_id(Long coffee_id) {
        this.coffee_id = coffee_id;
    }

    public Long getVolume_id() {
        return volume_id;
    }

    public void setVolume_id(Long volume_id) {
        this.volume_id = volume_id;
    }
}
