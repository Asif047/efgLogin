package com.nanotech.DiscoverBangladesh.Division;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nanotech.DiscoverBangladesh.R;
import com.nanotech.DiscoverBangladesh.District.DistrictActivity;

public class DhakaDivisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_division);
    }

    public void goToDhakaDistrictOnClick(View view) {

        Intent intent=new Intent(DhakaDivisionActivity.this, DistrictActivity.class);
        intent.putExtra("id","1");
        startActivity(intent);
    }
}
