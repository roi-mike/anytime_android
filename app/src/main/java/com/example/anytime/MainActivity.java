package com.example.anytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.anytime.pages.TopicsLearnActivity;


import android.Manifest;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;


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
                    finish();
                }
            }
        };
        timer.start();

        // Vérifier si la permission INTERNET est accordée
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            // Demander la permission INTERNET
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, REQUEST_CODE);
        } else {
            // La permission INTERNET est déjà accordée
            Log.d("PERMISSION 1 - 1", "onRequestPermissionsResult: La permission INTERNET est déjà accordée");
            // Faites ce que vous devez faire ici
        }

    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults); // Appeler la méthode parent

        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // La permission INTERNET a été accordée
                Log.d("PERMISSION 2 - 1", "onRequestPermissionsResult: La permission INTERNET a été accordée");
                // Faites ce que vous devez faire ici
            } else {
                // La permission INTERNET a été refusée
                Log.d("PERMISSION 2 - 2", "onRequestPermissionsResult: La permission INTERNET a été refusée");
                // Gérez le refus de la permission ici
            }
        }
    }
}