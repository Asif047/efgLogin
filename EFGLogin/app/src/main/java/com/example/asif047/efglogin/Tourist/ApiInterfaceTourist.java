package com.example.asif047.efglogin.Tourist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by encrypt on 10/8/17.
 */

public interface ApiInterfaceTourist {

    @GET("Tourist")
    Call<List<Tourist>>getTourist();

}
