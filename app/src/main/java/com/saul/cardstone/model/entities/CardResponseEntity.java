package com.saul.cardstone.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Saul on 17/02/2017.
 */

public class CardResponseEntity {
    @SerializedName("success") String success;
    @SerializedName("deck_id") String deckId;
    @SerializedName("remaining") int remaining;
    @SerializedName("cards") List<CardResultsEntity> card;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public List<CardResultsEntity> getCard() {
        return card;
    }

    public void setCard(List<CardResultsEntity> card) {
        this.card = card;
    }
}
