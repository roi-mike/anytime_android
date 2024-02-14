package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.anytime.R;
import com.example.anytime.services.managers.TokenManager;
import com.example.anytime.tools.utils.JTWUtils;

import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilActivity extends AppCompatActivity {

    private TextView editprofil;
    private CircleImageView profileImageView;

    private TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        editprofil = findViewById(R.id.editprofil);

        profileImageView = findViewById(R.id.profileImageView);

        tokenManager = TokenManager.getInstance(this);

        try {
            JSONObject jtwutils = JTWUtils.decoded(tokenManager.getToken());
            String first_name = jtwutils.getString("first_name");
            Log.d("37 JSON first_name : ", first_name);
            //TODO lundi 8 janvier a continuer pour Mardi LIGNE 41
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Log.d("34 TOKEN", tokenManager.getToken());

        editprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilActivity.this, EditProfilActivity.class);
                startActivity(intent);
            }
        });

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilActivity.this, TakePictureAndVideoActivity.class);
                startActivity(intent);
            }
        });




    }
}