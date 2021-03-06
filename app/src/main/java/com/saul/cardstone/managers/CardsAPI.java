package com.saul.cardstone.managers;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saul.cardstone.model.Card;
import com.saul.cardstone.model.Deck;
import com.saul.cardstone.model.entities.CardResponseEntity;
import com.saul.cardstone.model.entities.CardResultsEntity;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class CardsAPI {

    public void drawCard(Context context, final Deck deck, final Card card){

        String newCardURL = "https://deckofcardsapi.com/api/deck/" + deck.getId() + "/draw/?count=1";
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(newCardURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Reader reader = new StringReader(response);
                Gson gson = new GsonBuilder().create();

                CardResponseEntity cardResponse = gson.fromJson(reader, CardResponseEntity.class);

                List<CardResultsEntity> cardResultsEntity = cardResponse.getCard();
                for (CardResultsEntity result: cardResultsEntity) {
                    card.setImage(result.getImage());
                }
                deck.setRemaining(cardResponse.getRemaining());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }




    public void newDeck(Context context, final Deck deck){

        String newDeckURL = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(newDeckURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Reader reader = new StringReader(response);
                Gson gson = new GsonBuilder().create();

                CardResponseEntity cardResponse = gson.fromJson(reader, CardResponseEntity.class);
                deck.setId(cardResponse.getDeckId());
                deck.setRemaining(cardResponse.getRemaining());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(request);
    }
}
