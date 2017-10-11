package com.example.asif047.efglogin.ShowDistrict;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.asif047.efglogin.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class ShowDistrictActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapterShowDistrict adapterShowDistrict;
    private List<ShowDistrict>showDistricts;
    private ApiInterfaceShowDistrict apiInterfaceShowDistrict;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_district);



        //new starts
        final ProgressDialog mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        //new ends


        recyclerView= (RecyclerView) findViewById(R.id.recylerview_show_district);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        apiInterfaceShowDistrict=ApiClientShowDistrict.getApiClientShowDistrict().create(ApiInterfaceShowDistrict.class);




        //new starts

        String apiId=getIntent().getStringExtra("id");

        String urlString="division/"+apiId;





        //new ends


        Call<List<ShowDistrict>>call=apiInterfaceShowDistrict.getShowDistrict(urlString);

        call.enqueue(new Callback<List<ShowDistrict>>() {
            @Override
            public void onResponse(Call<List<ShowDistrict>> call, Response<List<ShowDistrict>> response) {

                //new starts

                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                //new ends



                showDistricts=response.body();

                Toast.makeText(ShowDistrictActivity.this,""+showDistricts.get(0).getDistrictName(),Toast.LENGTH_LONG).show();

                adapterShowDistrict=new RecyclerAdapterShowDistrict(ShowDistrictActivity.this,showDistricts);
                recyclerView.setAdapter(adapterShowDistrict);
            }

            @Override
            public void onFailure(Call<List<ShowDistrict>> call, Throwable t) {

            }
        });
    }
}
