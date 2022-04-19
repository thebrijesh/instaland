package com.example.instaland.adapter;

import android.icu.text.Transliterator;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.room.parser.expansion.Position;

import com.example.instaland.fragment.Notificationtab;
import com.example.instaland.fragment.Requesttab;

public class ViewPagerad extends FragmentPagerAdapter {
    public ViewPagerad(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){

            case 0 :return new Notificationtab();
            case 1 :return new Requesttab();
            default :return new Notificationtab();

        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;

        if (position == 0){

            title = "NOTIFICATION";


        }
        else if (position == 1){

            title = "REQUEST";
        }
        return title;
    }
}
