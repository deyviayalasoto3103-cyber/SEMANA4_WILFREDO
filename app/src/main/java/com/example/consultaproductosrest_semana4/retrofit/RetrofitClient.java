package com.example.consultaproductosrest_semana4.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://fakestoreapi.com/";
    private static Retrofit instancia = null;

    public static Retrofit getCliente() {
        if (instancia == null) {
            instancia = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instancia;
    }
}