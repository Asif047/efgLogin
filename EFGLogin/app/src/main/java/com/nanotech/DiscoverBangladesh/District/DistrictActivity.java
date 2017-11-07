package com.nanotech.DiscoverBangladesh.District;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.nanotech.DiscoverBangladesh.R;

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


                case R.id.navigation_security:
                    transaction.replace(R.id.content,new SecurityFragment()).commit();
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

//Toast.makeText(DistrictActivity.this,""+id,Toast.LENGTH_LONG).show();






//        //new ends


        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new TouristFragment()).commit();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_district);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }







    public String getMyData() {
        return id;
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
