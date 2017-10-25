package com.example.asif047.efglogin.FeaturedPlaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by encrypt on 10/17/17.
 */

public interface ApiInterfacePlaces {

    @GET("api/feature")
    Call<List<FeaturedPlaces>> getPlaces();
}
