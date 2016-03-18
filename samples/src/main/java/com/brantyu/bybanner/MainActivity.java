package com.brantyu.bybanner;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.brantyu.bybannerlib.BYBanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentPagerAdapter adapter = new TestFragmentAdapter(getSupportFragmentManager());
        BYBanner banner = (BYBanner) findViewById(R.id.banner);
        banner.setAdapter(adapter);
        banner.setAutoScroll(true);
    }
}
