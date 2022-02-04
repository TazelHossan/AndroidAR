package com.example.artest;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class JU extends AppCompatActivity {
    CardView university_card_ju ;
    Intent i ;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_map);

        ll = (LinearLayout) findViewById(R.id.ll);

        university_card_ju = (CardView) findViewById(R.id.DairyToCSE);

        i = new Intent(this,JUMap.class);
        university_card_ju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

    }
}
