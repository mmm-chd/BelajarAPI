package com.intent.belajarapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    // Set your base URL here
    private static final String BASE_URL = "https://www.thesportsdb.com";

    // Retrofit instance
    private static Retrofit retrofit = null;

    // Get Retrofit instance method
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
