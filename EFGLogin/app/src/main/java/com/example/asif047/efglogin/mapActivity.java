package com.example.asif047.efglogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.asif047.efglogin.Fragment.BlogFragment;
import com.example.asif047.efglogin.Fragment.FeaturedPlacesFragment;
import com.example.asif047.efglogin.Fragment.HomeFragment;
import com.example.asif047.efglogin.Fragment.NotificationFragment;
import com.example.asif047.efglogin.Fragment.SettingsFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MapActivity extends AppCompatActivity {



    //new starts
    public static final String DEFAULT="N/A";
    //new ends


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







        SharedPreferences sharedPreferences=getSharedPreferences("SoundData",this.MODE_PRIVATE);

        String soundInfo=sharedPreferences.getString("sound_info",DEFAULT);

//        if(soundInfo.equals(DEFAULT))
//        {
//            Toast.makeText(this,"No data was found",Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            Toast.makeText(this,"Data loaded successfully",Toast.LENGTH_LONG).show();
//        }




        if(soundInfo.equals("Sound off"))
        startService(new Intent(MapActivity.this, SoundService.class));

        else
            stopService(new Intent(MapActivity.this, SoundService.class));

        //super.onCreate(savedInstanceState);





        //new starts
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        FirebaseUser user=firebaseAuth.getCurrentUser();

        Toast.makeText(MapActivity.this,user.getDisplayName(),Toast.LENGTH_LONG).show();

        //new neds



        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new HomeFragment()).commit();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public void logOutOnClick(MenuItem item) {

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this,MainActivity.class));

    }







    //back button operation starts

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


    //back button operation ends





}
