package com.example.administracindecondominios.restclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/consultarCondominios")
    Call<List<Condominio>> doGetCondominios(@Query("id") String id);
}
