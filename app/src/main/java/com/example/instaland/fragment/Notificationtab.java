package com.example.instaland.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instaland.R;
import com.example.instaland.adapter.NotificationAd;
import com.example.instaland.model.NotificationModel;

import java.util.ArrayList;


public class Notificationtab extends Fragment {
RecyclerView recyclerView;
ArrayList<NotificationModel> list;


    public Notificationtab() {
        // Required empty public constructor
    }


    public static Notificationtab newInstance(String param1, String param2) {
        Notificationtab fragment = new Notificationtab();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notificationtab, container, false);
recyclerView = view.findViewById(R.id.notitabrv);
list  = new ArrayList<>();
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));
list.add(new NotificationModel(R.drawable.home,"Hey <b>Brijesh</b> This Person Mention you ","just now"));


        NotificationAd notificationAd = new NotificationAd(list,getContext());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(notificationAd);



        return view;
    }
}