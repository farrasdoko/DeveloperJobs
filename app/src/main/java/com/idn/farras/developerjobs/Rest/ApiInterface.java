package com.idn.farras.developerjobs.Rest;

import com.google.gson.JsonArray;
import com.idn.farras.developerjobs.Model.ResponseJobs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("positions.json")
    Call<JsonArray> getJobs(
            @Query("description") String description,
            @Query("location") String location
    );
}
