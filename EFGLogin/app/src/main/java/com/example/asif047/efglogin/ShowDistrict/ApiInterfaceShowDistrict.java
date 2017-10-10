package com.example.asif047.efglogin.ShowDistrict;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by encrypt on 10/10/17.
 */

public interface ApiInterfaceShowDistrict {

    @GET("division/1")
    Call<List<ShowDistrict>>getShowDistrict();

}
