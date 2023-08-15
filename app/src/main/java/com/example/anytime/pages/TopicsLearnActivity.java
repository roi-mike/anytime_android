package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anytime.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class TopicsLearnActivity extends AppCompatActivity {


    private ImageView listverb;
    private ImageView listbooks;



    private RelativeLayout relativeLayout;
    private int initialHeight;

    private CircleImageView profileImageView;
    private TextView loginbtn;

    CheckLoginForBtnConnection checkLoginForBtnConnection = CheckLoginForBtnConnection.NOTLOGIN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_learn);


        listverb = findViewById(R.id.listverb);
        listbooks = findViewById(R.id.listbooks);


        relativeLayout = findViewById(R.id.menubarelement);
        initialHeight = relativeLayout.getHeight();
        profileImageView = findViewById(R.id.profileImageView); // ENUM
        loginbtn = findViewById(R.id.loginbtn);

        listverb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicsLearnActivity.this, ListVerbsActivity.class);
                startActivity(intent);
            }
        });

        listbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicsLearnActivity.this, ListBooksActivity.class);
                startActivity(intent);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicsLearnActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        if (checkLoginForBtnConnection == CheckLoginForBtnConnection.LOGIN){
            profileImageView.setVisibility(View.VISIBLE);
        } else {
            profileImageView.setVisibility(View.INVISIBLE);
        }

        if (checkLoginForBtnConnection == CheckLoginForBtnConnection.NOTLOGIN){
            loginbtn.setVisibility(View.VISIBLE);
        } else {
            loginbtn.setVisibility(View.INVISIBLE);
        }

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopicsLearnActivity.this, "PHOTO CLUQE ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TopicsLearnActivity.this,ProfilActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            menubaranimation();
        }
    }

    private void menubaranimation() {
        final int initialHeight = relativeLayout.getHeight();
        final int targetHeight = initialHeight * 2;

        ValueAnimator anim = ValueAnimator.ofInt(initialHeight, targetHeight);
        anim.setDuration(1500);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int newHeight = (int) animation.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = newHeight;
                relativeLayout.setLayoutParams(layoutParams);

                if (newHeight > 368) {
                    anim.cancel();
                    menubaranimation();
                }
            }
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (relativeLayout.getHeight() > 368) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams.height = initialHeight;
                    relativeLayout.setLayoutParams(layoutParams);
                }
            }
        });
        anim.start();
    }

}