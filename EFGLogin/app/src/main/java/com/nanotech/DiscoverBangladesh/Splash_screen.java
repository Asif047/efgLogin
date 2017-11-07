package com.nanotech.DiscoverBangladesh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nanotech.DiscoverBangladesh.R;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);   // set the duration of splash screen
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash_screen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();


    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
