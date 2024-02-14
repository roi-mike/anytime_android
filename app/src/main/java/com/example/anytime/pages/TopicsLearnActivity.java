package com.example.anytime.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anytime.R;
import com.example.anytime.tools.animationtools.SinglettonConnectionChecker;

import de.hdodenhof.circleimageview.CircleImageView;


public class TopicsLearnActivity extends AppCompatActivity {

    private ImageView listverb;
    private ImageView listbooks;

    private RelativeLayout topicslearnactivityrelativelayout, firstLayoutProposision, firstLayoutProposisionRelativeLayoutVerbs, firstLayoutProposisionRelativeLayoutDiscution, firstLayoutProposisionRelativeLayoutPodCast, secondLayoutProposision, secondLayoutProposisionBooks, secondLayoutProposisionSpeak, secondLayoutProposisioWriting;


    private RelativeLayout relativeLayout;
    private int initialHeight;
    private int sizeHeightlayoutParamsFirstAndSecondLayoutProposision;
    private int sizeHeightlayoutParamsFirstAndSecondLayoutProposision2;

    private CircleImageView profileImageView;
    private TextView loginbtn;

    private SinglettonConnectionChecker singlettonConnectionChecker;

    //public static final String SHARED_PREFS = "sharedPrefs";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_learn);

        relativeLayout = findViewById(R.id.menubarelement);
        initialHeight = relativeLayout.getHeight();


        //Liste de RelativeLayout
        topicslearnactivityrelativelayout = findViewById(R.id.topicslearnactivityrelativelayout);
        firstLayoutProposision = findViewById(R.id.firstLayoutProposision);
        firstLayoutProposisionRelativeLayoutVerbs = findViewById(R.id.firstLayoutProposisionRelativeLayoutVerbs);
        firstLayoutProposisionRelativeLayoutDiscution = findViewById(R.id.firstLayoutProposisionRelativeLayoutDiscution);
        firstLayoutProposisionRelativeLayoutPodCast = findViewById(R.id.firstLayoutProposisionRelativeLayoutPodCast);
        secondLayoutProposision = findViewById(R.id.secondLayoutProposision);
        secondLayoutProposisionBooks = findViewById(R.id.secondLayoutProposisionBooks);
        secondLayoutProposisionSpeak = findViewById(R.id.secondLayoutProposisionSpeak);
        secondLayoutProposisioWriting = findViewById(R.id.secondLayoutProposisioWriting);


        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        int width = point.x;
        int height = point.y;

        sizeHeightlayoutParamsFirstAndSecondLayoutProposision = ((height - (relativeLayout.getHeight() + 368)) / 2 );











        listverb = findViewById(R.id.listverb);
        listbooks = findViewById(R.id.listbooks);

        //image arrondi de 20%
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.listverbs);

        //BitmapDrawable roundedDrawable = new BitmapDrawable(getResources(), bitmap);
        //roundedDrawable.setCornerRadius(20); // Rayon des coins arrondis en pixels

        //ImageView imageView = findViewById(R.id.listbooks);
        //imageView.setImageDrawable(roundedDrawable);s





        profileImageView = findViewById(R.id.profileImageView); // ENUM
        loginbtn = findViewById(R.id.loginbtn);

        singlettonConnectionChecker = SinglettonConnectionChecker.getInstance();

        Log.i(" SecondLayoutProposision : ", String.valueOf(sizeHeightlayoutParamsFirstAndSecondLayoutProposision + "px"));




        //SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferences.edit();

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


        if (singlettonConnectionChecker.getSinglettonConnectionChecker() == CheckLoginForBtnConnection.LOGIN){
            profileImageView.setVisibility(View.VISIBLE);
        } else {
            profileImageView.setVisibility(View.INVISIBLE);
        }

        if (singlettonConnectionChecker.getSinglettonConnectionChecker() == CheckLoginForBtnConnection.NOTLOGIN){
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






            RelativeLayout.LayoutParams layoutParamsFirstLayoutProposision = (RelativeLayout.LayoutParams) firstLayoutProposision.getLayoutParams();
            layoutParamsFirstLayoutProposision.height = sizeHeightlayoutParamsFirstAndSecondLayoutProposision;
            layoutParamsFirstLayoutProposision.addRule(firstLayoutProposision.BELOW, R.id.menubarelement);

            RelativeLayout.LayoutParams layoutParamsSecondeLayoutProposision = (RelativeLayout.LayoutParams) secondLayoutProposision.getLayoutParams();
            layoutParamsSecondeLayoutProposision.height = sizeHeightlayoutParamsFirstAndSecondLayoutProposision;
            layoutParamsSecondeLayoutProposision.addRule(secondLayoutProposision.BELOW,R.id.firstLayoutProposision);

            RelativeLayout.LayoutParams layoutParamsFirstLayoutProposisionRelativeLayoutDiscution = (RelativeLayout.LayoutParams) firstLayoutProposisionRelativeLayoutDiscution.getLayoutParams();
            layoutParamsFirstLayoutProposisionRelativeLayoutDiscution.height = sizeHeightlayoutParamsFirstAndSecondLayoutProposision / 2;

            RelativeLayout.LayoutParams layoutParamsFirstLayoutProposisionRelativeLayoutPodCast = (RelativeLayout.LayoutParams)   firstLayoutProposisionRelativeLayoutPodCast.getLayoutParams();
            layoutParamsFirstLayoutProposisionRelativeLayoutPodCast.height = sizeHeightlayoutParamsFirstAndSecondLayoutProposision / 2;

            RelativeLayout.LayoutParams layoutParamsSecondLayoutProposisionSpeak = (RelativeLayout.LayoutParams) secondLayoutProposisionSpeak.getLayoutParams();
            layoutParamsSecondLayoutProposisionSpeak.height = sizeHeightlayoutParamsFirstAndSecondLayoutProposision / 2;

            RelativeLayout.LayoutParams layoutParamsSecondLayoutProposisioWriting = (RelativeLayout.LayoutParams) secondLayoutProposisioWriting.getLayoutParams();
            layoutParamsSecondLayoutProposisioWriting.height = sizeHeightlayoutParamsFirstAndSecondLayoutProposision / 2;



            //changer la taille des 2 relatives layout
            firstLayoutProposision.setLayoutParams(layoutParamsFirstLayoutProposision);
            secondLayoutProposision.setLayoutParams(layoutParamsSecondeLayoutProposision);






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