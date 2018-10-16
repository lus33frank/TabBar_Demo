package com.frankchang.tabbar_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // TabLayout + ViewPager
    public void btn1OnClick(View view) {
        startActivity(new Intent(MainActivity.this, Tab1Activity.class));
    }

    // TabLayout + Fragment
    public void btn2OnClick(View view) {
        startActivity(new Intent(MainActivity.this, Tab2Activity.class));
    }

    // BottomNavigationView + Fragment
    public void btn3OnClick(View view) {
        startActivity(new Intent(MainActivity.this, Tab3Activity.class));
    }

}
