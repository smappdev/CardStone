package com.saul.cardstone.model;

/**
 * Created by Saul on 17/02/2017.
 */

public class Deck {

    private String id;
    private int remaining;

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
