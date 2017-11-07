package com.nanotech.DiscoverBangladesh.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 10/7/2017.
 */

public interface ApiInterface {

    @GET("Hotel")
    Call<List<Hotel>> getHotel();
}
