package com.nanotech.DiscoverBangladesh.Hospital;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by encrypt on 10/8/17.
 */

public class ApiClientHospital {

    public static final String BASE_URL="http://discover.nanotech.com.bd/api/place/";
    public static Retrofit retrofit=null;


    public static Retrofit getApiClient()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

}
