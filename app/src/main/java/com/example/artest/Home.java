package com.example.artest;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Home extends AppCompatActivity {
CardView card_kids, card_universities, card_livechat ;
    Intent i1, i2, i3 ;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ll = (LinearLayout) findViewById(R.id.ll);

        card_kids = (CardView) findViewById(R.id.kids);
        i1 = new Intent(this,MainActivity.class);
        card_kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i1);
            }
        });

        card_universities = (CardView) findViewById(R.id.universites);

        i2 = new Intent(this,Universities.class);

        card_universities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i2);
            }
        });


        card_livechat = (CardView) findViewById(R.id.livechat);

        i3 = new Intent(this,Livechat.class);

        card_livechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i3);
            }
        });

    }
}
