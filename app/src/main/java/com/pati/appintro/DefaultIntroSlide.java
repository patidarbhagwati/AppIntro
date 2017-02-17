/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.pati.appintro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;

/**
 * Created by developer on 17/2/17.
 */
public class DefaultIntroSlide extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Down here, we add the xml layouts into sample slide inflater.
        addSlide(MySlides.newInstance(R.layout.slide));
        addSlide(MySlides.newInstance(R.layout.slide2));
        addSlide(MySlides.newInstance(R.layout.slide3));
        addSlide(MySlides.newInstance(R.layout.slide4));

        showStatusBar(true);
        setDepthAnimation();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        loadMainActivity();
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    public void getStarted(View v){
        loadMainActivity();
    }
}
