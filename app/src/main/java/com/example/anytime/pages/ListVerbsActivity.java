package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anytime.R;

public class ListVerbsActivity extends AppCompatActivity {

    private Button btnMenuListVerb, btnQcmPerso;
    private int toggleDisplayMenu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listverbs);

        btnMenuListVerb = findViewById(R.id.btnMenuListVerb);
        btnQcmPerso = findViewById(R.id.btnQcmPerso);

        btnQcmPerso.setVisibility(View.INVISIBLE);

        btnMenuListVerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleDisplayMenu == 0){
                    btnQcmPerso.setVisibility(View.VISIBLE);
                    toggleDisplayMenu = 1;
                } else {
                    btnQcmPerso.setVisibility(View.INVISIBLE);
                    toggleDisplayMenu = 0;
                }
            }
        });

        btnQcmPerso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListVerbsActivity.this, TopicsLearnActivity.class);
                startActivity(intent);
            }
        });





    }
}