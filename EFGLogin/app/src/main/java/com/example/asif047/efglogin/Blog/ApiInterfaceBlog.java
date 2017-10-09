package com.example.asif047.efglogin.Blog;

import com.example.asif047.efglogin.Hotel.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by encrypt on 10/9/17.
 */

public interface ApiInterfaceBlog {

    @GET("Hotel")
    Call<List<Blog>> getBlog();
}
