package com.example.anytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.anytime.pages.TopicsLearnActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intentTopicsLearnPage = new Intent(MainActivity.this, TopicsLearnActivity.class);
                    startActivity(intentTopicsLearnPage);
                }
            }
        };
        timer.start();

    }
}