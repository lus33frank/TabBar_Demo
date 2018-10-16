package com.frankchang.tabbar_demo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Tab2Activity extends AppCompatActivity {

    private TabLayout tabs2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        finViews();
        init();
    }

    private void finViews() {
        tabs2 = findViewById(R.id.tabs2);
        tabs2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void init() {
        onTabItemSelected(0);
    }

    private void onTabItemSelected(int position) {
        String message = "";

        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new TabFragment();
                message = "Tab 1 Page";
                break;
            case 1:
                fragment = new TabFragment();
                message = "Tab 2 Page";
                break;

            case 2:
                fragment = new TabFragment();
                message = "Tab 3 Page";
                break;
            case 3:
                fragment = new TabFragment();
                message = "Tab 4 Page";
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putString("message", message);

        if (fragment != null) {
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment2, fragment)
                    .commit();
        }
    }

}
