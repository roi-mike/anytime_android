package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anytime.R;

public class EditProfilActivity extends AppCompatActivity {


    private TextView changepicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);


        changepicture = (TextView) findViewById(R.id.changepicture);

        changepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfilActivity.this, TopicsLearnActivity.class);
                startActivity(intent);
            }
        });



    }
}