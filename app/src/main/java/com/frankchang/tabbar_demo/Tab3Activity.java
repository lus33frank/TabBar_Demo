package com.frankchang.tabbar_demo;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class Tab3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        findViews();
        init();
    }

    private void findViews() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_tab1:
                        onTabItemSelected(0);
                        return true;
                    case R.id.navigation_tab2:
                        onTabItemSelected(1);
                        return true;
                    case R.id.navigation_tab3:
                        onTabItemSelected(2);
                        return true;
                    case R.id.navigation_tab4:
                        onTabItemSelected(3);
                        return true;
                }
                return false;
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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment3, fragment)
                    .commit();
        }
    }

}
