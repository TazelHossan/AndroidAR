package com.example.artest;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Universities extends AppCompatActivity {
    CardView university_card_ju ;
    Intent i1 ;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universities);

        ll = (LinearLayout) findViewById(R.id.ll);

        university_card_ju = (CardView) findViewById(R.id.JU);

        i1 = new Intent(this,JU.class);

        university_card_ju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i1);
            }
        });

    }
}
