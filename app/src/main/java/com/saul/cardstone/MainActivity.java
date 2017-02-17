package com.saul.cardstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.saul.cardstone.managers.CardsAPI;
import com.saul.cardstone.model.Deck;

public class MainActivity extends AppCompatActivity {

    ImageView cardImageView;
    TextView remainingTextView;
    Deck deck = new Deck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardImageView = (ImageView) findViewById(R.id.activity_main___card_image_view);
        remainingTextView = (TextView) findViewById(R.id.activity_main___remaining_text_view);

        final CardsAPI cardsAPI = new CardsAPI();

        cardImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardsAPI.newDeck(view.getContext(), deck);
                System.out.println(deck.getId());
            }
        });
    }
}
