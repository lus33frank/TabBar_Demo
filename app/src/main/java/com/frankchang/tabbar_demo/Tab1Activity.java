package com.frankchang.tabbar_demo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class Tab1Activity extends AppCompatActivity {

    private TabLayout tabs1;
    private ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);

        findViews();
    }

    private void findViews() {
        tabs1 = findViewById(R.id.tabs1);
        vp = findViewById(R.id.viewPager);
        tabs1.setupWithViewPager(vp);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setupViewPager(vp);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(getFragment(0), "Machine");
        adapter.addFragment(getFragment(1), "Notification");
        adapter.addFragment(getFragment(2), "Setting");
        adapter.addFragment(getFragment(3), "About");
        viewPager.setAdapter(adapter);

        tabs1.getTabAt(0).setIcon(R.drawable.baseline_filter_1_white_18);
        tabs1.getTabAt(1).setIcon(R.drawable.baseline_filter_2_white_18);
        tabs1.getTabAt(2).setIcon(R.drawable.baseline_filter_3_white_18);
        tabs1.getTabAt(3).setIcon(R.drawable.baseline_filter_4_white_18);
    }

    private Fragment getFragment(int position) {
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
        }

        return fragment;
    }

    private class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

    }

}
