package com.example.asif047.efglogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mapActivity extends AppCompatActivity {




    private FirebaseAuth firebaseAuth;

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


        //new starts


        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        FirebaseUser user=firebaseAuth.getCurrentUser();



        if(user.getDisplayName()!=null)
            Toast.makeText(mapActivity.this,user.getDisplayName(),Toast.LENGTH_LONG).show();
        if(user.getDisplayName()==null)
            Toast.makeText(mapActivity.this,user.getDisplayName(),Toast.LENGTH_LONG).show();





        //new ends



        //By default showing home fragment
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new HomeFragment()).commit();



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    //new starts


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.map_menu,menu);
        return true;
    }


    //new ends
//
//    public void goToHome(MenuItem item) {
//
//        transaction.replace(R.id.content,new HomeFragment()).commit();
//    }
//
//    public void goToBlog(MenuItem item) {
//    }
//
//    public void goToFeaturedPlaces(MenuItem item) {
//    }
//
//    public void goToNotifications(MenuItem item) {
//    }
//
//    public void goToSettings(MenuItem item) {
//    }

    public void goToLogOut(MenuItem item) {

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this,MainActivity.class));

    }
}
