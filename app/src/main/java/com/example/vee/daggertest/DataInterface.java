package com.example.vee.daggertest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInterface {
    @GET("users/")
    Call<List<Users>> getAllUsers();
}
