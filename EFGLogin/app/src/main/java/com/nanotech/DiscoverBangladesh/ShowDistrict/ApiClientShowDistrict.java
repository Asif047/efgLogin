package com.nanotech.DiscoverBangladesh.ShowDistrict;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by encrypt on 10/10/17.
 */

public class ApiClientShowDistrict {

    public static final String BASE_URL="http://discover.nanotech.com.bd/api/";
    public static Retrofit retrofit=null;


    //new starts
    private String id="1";
    //new ends


    public static Retrofit getApiClientShowDistrict()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }



    public String getmyData()
    {
        return id;
    }


}
