package com.example.asif047.efglogin.Hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asif047.efglogin.Hotel.RecyclerAdapter;
import com.example.asif047.efglogin.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapterHospital adapter;
    private List<Hospital> hospitals;
    private ApiInterfaceHospital apiInterfaceHospital;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        recyclerView= (RecyclerView) findViewById(R.id.recylerview_hospital);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterfaceHospital=ApiClientHospital.getApiClient().create(ApiInterfaceHospital.class);

        Call<List<Hospital>> call=apiInterfaceHospital.getHospital();

        call.enqueue(new Callback<List<Hospital>>() {
            @Override
            public void onResponse(Call<List<Hospital>> call, Response<List<Hospital>> response) {
                hospitals=response.body();
                adapter=new RecyclerAdapterHospital(getApplicationContext(),hospitals);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Hospital>> call, Throwable t) {

            }
        });

    }
}
