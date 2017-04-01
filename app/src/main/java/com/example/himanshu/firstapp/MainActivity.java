package com.example.himanshu.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIMEOUT=3000;
    private static String TAG="Debug";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, login.class);
                Log.d(TAG, "oncreate");
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_TIMEOUT);
        Log.d(TAG, "oncreate");

    }

}