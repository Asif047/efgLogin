package com.example.asif047.efglogin.Hospital;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by encrypt on 10/8/17.
 */

public interface ApiInterfaceHospital {


    @GET("Hospital")
    Call<List<Hospital>> getHospital();

}
