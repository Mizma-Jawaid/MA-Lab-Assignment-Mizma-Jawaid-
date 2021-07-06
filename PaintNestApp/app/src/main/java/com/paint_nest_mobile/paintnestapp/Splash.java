package com.paint_nest_mobile.paintnestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private static int timer = 4000;
    ImageView imageView;
    Animation upper_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);

        imageView =  findViewById(R.id.main_logo);
        upper_animation =    AnimationUtils.loadAnimation(this, R.anim.upper_animation);

        imageView.setAnimation(upper_animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Login.class);
                startActivity(intent);
                finish();
            }
        },timer);

    }

}