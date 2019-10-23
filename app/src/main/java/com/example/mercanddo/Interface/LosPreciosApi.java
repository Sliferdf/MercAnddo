package com.example.mercanddo.Interface;

import com.example.mercanddo.Model.Peticiones;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LosPreciosApi {

    @GET("detalles?ID=1&MunicipioID=2&ClaveAPI=5s8I_CKqFt*AiLT6")
    Call<Peticiones> getPost(@Query("Página") Integer[] pag );
}