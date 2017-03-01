package com.saul.cardstone.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Saul on 17/02/2017.
 */

public class CardResultsEntity {

    // image value suit code

    @SerializedName("image") String image;
    @SerializedName("value") String value;
    @SerializedName("suit") String suit;
    @SerializedName("code") String code;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
