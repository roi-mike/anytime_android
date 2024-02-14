package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anytime.R;
import com.example.anytime.interfaces.LoginInterface;
import com.example.anytime.services.AuthenticationServices;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    private TextView registerbtn;
    private Button loginbtn;

    private EditText emailtxt;

    private EditText passwordtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        registerbtn = findViewById(R.id.registerbtn);
        loginbtn = findViewById(R.id.loginbtn);

        emailtxt = findViewById(R.id.emailtxt);
        passwordtxt = findViewById(R.id.passwordtxt);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AuthenticationServices authenticationServices = new AuthenticationServices();

                LoginInterface loginInterface = new LoginInterface(emailtxt.getText().toString(),passwordtxt.getText().toString());

                Gson gson = new Gson();

                String json = gson.toJson(loginInterface);

                if (loginInterface.validateloginconnection(loginInterface)){
                    Toast.makeText(LoginActivity.this, "Verification dans la base de donnee", Toast.LENGTH_SHORT).show();
                    authenticationServices.checkloginconnection(LoginActivity.this, json);
                }

                //Intent intent = new Intent(LoginActivity.this, TopicsLearnActivity.class);
                //startActivity(intent);
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}