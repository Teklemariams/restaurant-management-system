package com.wengel.astenagaj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //splash screen
        EasySplashScreen splashScreen = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.WHITE)
//                .withHeaderText("Header")
//                .withFooterText("footer")
                .withBeforeLogoText("Astenagaj")
//                .withAfterLogoText("Discover destinations to experience more of nature")
//                .withAfterLogoText("Asgobgni")
                .withLogo(R.drawable.logo_louncher_background);

//        splashScreen.getHeaderTextView().setTextColor(Color.BLACK);
//        splashScreen.getFooterTextView().setTextColor(Color.BLACK);
        splashScreen.getBeforeLogoTextView().setTextSize(30);
//        splashScreen.getAfterLogoTextView().setTextSize(30);
        splashScreen.getBeforeLogoTextView().setTextColor(getResources().getColor(R.color.green));
//        splashScreen.getAfterLogoTextView().setTextColor(getResources().getColor(R.color.green));
        View easySplashScreen = splashScreen.create();

        setContentView(easySplashScreen);
        easySplashScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            }
        });

    }
}
