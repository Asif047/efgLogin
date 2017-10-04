package com.example.asif047.efglogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class mapActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content,new HomeFragment()).commit();

                    return true;
                case R.id.navigation_blog:
                    transaction.replace(R.id.content,new BlogFragment()).commit();

                    return true;
                case R.id.navigation_featured_places:
                    transaction.replace(R.id.content,new FeaturedPlacesFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.content,new NotificationFragment()).commit();
                    return true;
                case R.id.navigation_settings:
                    transaction.replace(R.id.content,new SettingsFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        //By default showing home fragment
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new HomeFragment()).commit();



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
