package com.nanotech.DiscoverBangladesh.Security;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 10/23/2017.
 */

public interface ApiInterfaceSecurity {

    @GET("Security")
    Call<List<Security>> getSecurity();
}
