package com.example.asif047.efglogin.District;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.asif047.efglogin.Fragment.BlogFragment;
import com.example.asif047.efglogin.Fragment.FeaturedPlacesFragment;
import com.example.asif047.efglogin.Fragment.HomeFragment;
import com.example.asif047.efglogin.Fragment.NotificationFragment;
import com.example.asif047.efglogin.Fragment.SettingsFragment;
import com.example.asif047.efglogin.MainActivity;
import com.example.asif047.efglogin.MapActivity;
import com.example.asif047.efglogin.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DistrictActivity extends AppCompatActivity {



    String id;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_tourist:
                    transaction.replace(R.id.content,new TouristFragment()).commit();

                    return true;
                case R.id.navigation_hotel:
                    transaction.replace(R.id.content,new HotelFragment()).commit();

                    return true;
                case R.id.navigation_hospital:

                    transaction.replace(R.id.content,new HospitalFragment()).commit();
                    return true;



            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);




        //new starts
        id=getIntent().getStringExtra("id");

Toast.makeText(DistrictActivity.this,""+id,Toast.LENGTH_LONG).show();




        Bundle bundle = new Bundle();
        bundle.putString("district_id", id);

// Your fragment
        HotelFragment obj = new HotelFragment();
        obj.setArguments(bundle);

//        //new ends


        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new TouristFragment()).commit();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_district);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.main_menu,menu);
//        return true;
//    }
//
//    public void logOutOnClick(MenuItem item) {
//
//        firebaseAuth.signOut();
//        finish();
//        startActivity(new Intent(this,MainActivity.class));
//
//    }
}
