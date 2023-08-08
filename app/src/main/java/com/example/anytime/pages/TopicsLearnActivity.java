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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.anytime.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class TopicsLearnActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;

    private CircleImageView profileImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_learn);

        relativeLayout = findViewById(R.id.menubarelement);
        profileImageView = findViewById(R.id.profileImageView);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopicsLearnActivity.this, "PHOTO CLUQE ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TopicsLearnActivity.this,ProfilActivity.class);
                startActivity(intent);
            }
        });



        Log.d("START", "onCreate: START");




    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            menubaranimation();
            Log.d("FINISH", "onCreate: FINISH");
        }
    }

    private void menubaranimation(){
        final int initialHeight = relativeLayout.getHeight();
        final int targetHeight = initialHeight * 2;

        ValueAnimator anim = ValueAnimator.ofInt(initialHeight, targetHeight);
        anim.setDuration(1500);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int height = (int) animation.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = height;
                relativeLayout.setLayoutParams(layoutParams);
            }
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // Animation finished
                Log.d("FINSH ANIMATION", "onAnimationEnd: ANIMATION FINI");
            }
        });
        anim.start();


    }

}