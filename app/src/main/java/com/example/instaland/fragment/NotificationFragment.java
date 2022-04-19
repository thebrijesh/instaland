package com.example.instaland.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.instaland.R;
import com.example.instaland.adapter.ViewPagerad;
import com.google.android.material.tabs.TabLayout;


public class NotificationFragment extends Fragment {


TabLayout tabLayout;

ViewPager viewpager;


    public NotificationFragment() {


    


}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notification, container, false);
        viewpager = view.findViewById(R.id.view_pager);
     viewpager.setAdapter(new ViewPagerad(getFragmentManager()));


        tabLayout = view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewpager);

        
        return view;
    }

}