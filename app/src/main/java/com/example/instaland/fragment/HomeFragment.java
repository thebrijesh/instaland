package com.example.instaland.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instaland.R;
import com.example.instaland.adapter.DashboardAd;
import com.example.instaland.adapter.StoryAdapter;
import com.example.instaland.model.DashboardModel;
import com.example.instaland.model.story;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private RecyclerView rec;
    private ArrayList<story> list;
    private ArrayList<DashboardModel> dashboardlist = new ArrayList<>();
    private RecyclerView dashboard;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        rec = view.findViewById(R.id.rec);
        list= new ArrayList<story>();

        list.add(new story(R.drawable.ic_launcher_foreground,R.drawable.ic_baseline_live_tv_24,R.drawable.home,"Brijesh"));
        list.add(new story(R.drawable.ic_launcher_foreground,R.drawable.ic_baseline_live_tv_24,R.drawable.home,"Brijesh"));
        list.add(new story(R.drawable.ic_launcher_foreground,R.drawable.ic_baseline_live_tv_24,R.drawable.home,"Brijesh"));
        list.add(new story(R.drawable.ic_launcher_foreground,R.drawable.ic_baseline_live_tv_24,R.drawable.home,"Brijesh"));
//        list.add(new story(R.drawable.ic_launcher_foreground,R.drawable.ic_baseline_live_tv_24,R.drawable.home,"Brijesh"));

        StoryAdapter storyAdapter = new StoryAdapter(list,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rec.setLayoutManager(layoutManager);
        rec.setNestedScrollingEnabled(false);
        rec.setAdapter(storyAdapter);

        dashboard = view.findViewById(R.id.dashboard);
        dashboardlist.add(new DashboardModel(R.drawable.home,R.drawable.groupimg,R.drawable.ribbon,"Brijesh Patel","about","556","24","18"));
        dashboardlist.add(new DashboardModel(R.drawable.home,R.drawable.groupimg,R.drawable.ribbon,"Brijesh Patel","about","556","24","18"));
        dashboardlist.add(new DashboardModel(R.drawable.home,R.drawable.groupimg,R.drawable.ribbon,"Brijesh Patel","about","556","24","18"));
        dashboardlist.add(new DashboardModel(R.drawable.home,R.drawable.groupimg,R.drawable.ribbon,"Brijesh Patel","about","556","24","18"));
        dashboardlist.add(new DashboardModel(R.drawable.home,R.drawable.groupimg,R.drawable.ribbon,"Brijesh Patel","about","556","24","18"));

        DashboardAd dashboardAd = new DashboardAd(dashboardlist,getContext());
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        dashboard.setLayoutManager(layoutManager1);
        dashboard.setNestedScrollingEnabled(false);
        dashboard.setAdapter(dashboardAd);

        return view;
    }
}