package com.example.user.application;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish(); //Activity 를 종료하는 메소드를 넣어주세요 !

            }
        }, 3000);

   //     Intent intent = new Intent(this, LoginActivity.class);
  //      startActivity(intent);
    }
}
