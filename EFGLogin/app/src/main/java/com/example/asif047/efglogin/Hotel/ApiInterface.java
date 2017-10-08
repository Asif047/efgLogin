package com.example.asif047.efglogin.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by admin on 10/7/2017.
 */

public interface ApiInterface {

    @GET("api/place/1/Hotel")
    Call<List<Hotel>> getHotel();
}
