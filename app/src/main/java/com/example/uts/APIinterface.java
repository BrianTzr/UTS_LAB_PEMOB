package com.example.uts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {
    @GET("/cardinfo.php?num=500")
    Call<List<Post>> getPosts();
}
