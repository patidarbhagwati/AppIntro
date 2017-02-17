/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.pati.appintro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by developer on 17/2/17.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences  sharedPreferences = getSharedPreferences(Config.FLAG, Context.MODE_PRIVATE);
                if(sharedPreferences.getBoolean(Config.FLAG,true)){
                    startActivity(new Intent(MainActivity.this,DefaultIntroSlide.class));
                    SharedPreferences.Editor edit =sharedPreferences.edit();
                    edit.putBoolean(Config.FLAG,false);
                    edit.apply();
                }
            }
        });
        thread.start();
    }
}
