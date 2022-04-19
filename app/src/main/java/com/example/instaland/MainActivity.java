package com.example.instaland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.instaland.fragment.AddFragment;
import com.example.instaland.fragment.HomeFragment;
import com.example.instaland.fragment.NotificationFragment;
import com.example.instaland.fragment.ProfileFragment;
import com.example.instaland.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottom_navigation;
    private FrameLayout main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       bottom_navigation =findViewById(R.id.bottom_navigation);
       main =findViewById(R.id.main);



        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main, new HomeFragment());
        transaction.commit();



        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){

                    case R.id.icon1:
                        transaction.replace(R.id.main, new HomeFragment());

                        break;

                    case R.id.icon2:
                        transaction.replace(R.id.main, new NotificationFragment());
                        break;

                    case R.id.icon3:

                        transaction.replace(R.id.main, new AddFragment());
                        break;

                    case R.id.icon4:
                        transaction.replace(R.id.main, new SearchFragment()
                        );
                        break;

                    case R.id.icon5:
                        transaction.replace(R.id.main, new ProfileFragment());
                        break;


                }
                transaction.commit();
                return true;
            }
        });
    }
}