package com.example.asif047.efglogin.Blog;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 10/11/2017.
 */

public class ApiClientBlog {

    public static final String BASE_URL="http://discover.nanotech.com.bd/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiclient()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
