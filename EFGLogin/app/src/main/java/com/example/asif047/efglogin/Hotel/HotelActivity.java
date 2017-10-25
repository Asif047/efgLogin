package com.example.asif047.efglogin.Hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asif047.efglogin.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Hotel> hotels;
    private ApiInterface apiInterface;



    //new starts
    public  String BASE_URL="";
    public  Retrofit retrofit=null;

    //new ends

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);




        //new starts

        String id=getIntent().getStringExtra("id");

        BASE_URL="http://discover.nanotech.com.bd/api/place/"+id+"/";

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //new ends


        recyclerView= (RecyclerView) findViewById(R.id.recylerview);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        //apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface=retrofit.create(ApiInterface.class);

        Call<List<Hotel>> call=apiInterface.getHotel();


        call.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                hotels=response.body();
               // Toast.makeText(HotelActivity.this,hotels.get(0).getImage().toString(),Toast.LENGTH_LONG).show();
                adapter=new RecyclerAdapter(getApplicationContext(),hotels);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {

            }
        });

    }
}
