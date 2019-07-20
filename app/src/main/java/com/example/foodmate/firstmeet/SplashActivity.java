package com.example.foodmate.firstmeet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.example.foodmate.MainActivity;
import com.example.foodmate.R;

public class SplashActivity extends AppCompatActivity {
    private RelativeLayout rlSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmeet1);
        rlSplash=(RelativeLayout)findViewById(R.id.rl_splash);
        startAnim();
    }

    private void startAnim() {
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                jumpnext();
            }

            private void jumpnext() {
                Intent intent=new Intent(SplashActivity.this, activity_guide.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rlSplash.setAnimation(alphaAnimation);
    }
}
