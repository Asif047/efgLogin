package com.example.asif047.efglogin.Tourist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asif047.efglogin.Hotel.Hotel;
import com.example.asif047.efglogin.Hotel.RecyclerAdapter;
import com.example.asif047.efglogin.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TouristActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapterTourist adapter;
    private List<Tourist> tourists;
    private ApiInterfaceTourist apiInterfaceTourist;




    //new starts
    public  String BASE_URL="";
    public Retrofit retrofit=null;

    //new ends


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);



        //new starts

        //String id=getIntent().getStringExtra("id");

        BASE_URL="http://discover.nanotech.com.bd/api/place/"+1+"/";

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //new ends



        recyclerView= (RecyclerView) findViewById(R.id.recylerview_tourist);
        layoutManager=new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //apiInterfaceTourist=ApiClientTourist.getApiClient().create(ApiInterfaceTourist.class);

        apiInterfaceTourist=retrofit.create(ApiInterfaceTourist.class);

        Call<List<Tourist>> call=apiInterfaceTourist.getTourist();

        call.enqueue(new Callback<List<Tourist>>() {
            @Override
            public void onResponse(Call<List<Tourist>> call, Response<List<Tourist>> response) {
                tourists=response.body();
                //tourists.get(0).getAddress();
                Toast.makeText(TouristActivity.this,tourists.get(0).getAddress().toString(),Toast.LENGTH_LONG).show();
                adapter=new RecyclerAdapterTourist(getApplicationContext(),tourists);

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Tourist>> call, Throwable t) {

            }
        });
    }
}
