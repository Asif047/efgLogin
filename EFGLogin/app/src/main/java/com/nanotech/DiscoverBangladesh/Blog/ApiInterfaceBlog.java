package com.nanotech.DiscoverBangladesh.Blog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 10/11/2017.
 */

public interface ApiInterfaceBlog {

    @GET("api/blogs")
    Call<List<Blog>> getBlogs();
}
