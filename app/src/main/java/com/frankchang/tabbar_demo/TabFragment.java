package com.frankchang.tabbar_demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TabFragment extends Fragment {

    // 元件
    private TextView tvShow;
    private View fragment2;
    // 變數
    private String message = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment2 = inflater.inflate(R.layout.fragment_tab, container, false);

        findViews();
        init();

        return fragment2;
    }

    private void init() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            message = bundle.getString("message");
        }
        tvShow.setText(message);
    }

    private void findViews() {
        tvShow = fragment2.findViewById(R.id.tvShowFrameInfo);
    }

}
