package com.example.gufran.viewanimationstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAlpha, buttonTranslate, buttonRotate, buttonScale, buttonSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAlpha = (Button) findViewById(R.id.buttonAlpha);
        buttonTranslate = (Button) findViewById(R.id.buttonTranslate);
        buttonRotate = (Button) findViewById(R.id.buttonRotate);
        buttonScale = (Button) findViewById(R.id.buttonScale);
        buttonSet = (Button) findViewById(R.id.buttonSet);

        final AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                buttonAlpha.setVisibility(Button.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        alphaAnimation.setDuration(2000);


        final RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.0f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatCount(3);

        buttonAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(alphaAnimation);
            }
        });

        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(rotateAnimation);
            }
        });

        final TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_PARENT, 1, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(2000);
        buttonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(translateAnimation);
            }
        });

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(translateAnimation);
    }


}
