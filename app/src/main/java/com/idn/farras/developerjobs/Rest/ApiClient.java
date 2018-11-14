package com.idn.farras.developerjobs.Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL="https://jobs.github.com/";

    public static ApiInterface apiInterface;

    public static ApiInterface getClient() {
        if (apiInterface == null) {
            Gson gson = new GsonBuilder()
//                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }

//    public static Retrofit setInit(){
//        return new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    public static ApiInterface getInstance(){
//        return setInit().create(ApiInterface.class);
//    }
}
