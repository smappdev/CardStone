package com.saul.cardstone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.saul.cardstone.managers.CardsAPI;
import com.saul.cardstone.model.Card;
import com.saul.cardstone.model.Deck;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView cardImageView;
    TextView remainingTextView;

    Card card = new Card();
    CardsAPI cardsAPI = new CardsAPI();
    Deck deck = new Deck();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardImageView = (ImageView) findViewById(R.id.activity_main___card_image_view);
        remainingTextView = (TextView) findViewById(R.id.activity_main___remaining_text_view);

        cardImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (deck.getRemaining() == 0) {
                    cardsAPI.newDeck(view.getContext(), deck);
                    remainingTextView.setText("Remaining: " + deck.getRemaining());
                }else{
                    cardsAPI.drawCard(view.getContext(), deck, card);
                    remainingTextView.setText("Remaining: " + deck.getRemaining());
                    System.out.println(deck.getId());

                    Picasso.with(view.getContext()).load(card.getImage()).into(cardImageView);
                }
            }
        });
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        cardsAPI.newDeck(this.getBaseContext(), deck);
        cardsAPI.newDeck(this.getBaseContext(), deck);
        cardsAPI.drawCard(getBaseContext(), deck, card);
        cardsAPI.drawCard(getBaseContext(), deck, card);
        cardsAPI.drawCard(getBaseContext(), deck, card);
        remainingTextView.setText("Remaining: 234234");
    }*/
}
