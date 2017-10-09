package com.example.asif047.efglogin.Division;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asif047.efglogin.Hotel.HotelActivity;
import com.example.asif047.efglogin.R;

public class DhakaDivisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_division);
    }

    public void goToDhakaDistrictOnClick(View view) {

        Intent intent=new Intent(DhakaDivisionActivity.this, HotelActivity.class);
        intent.putExtra("id","1");
        startActivity(intent);
    }
}
