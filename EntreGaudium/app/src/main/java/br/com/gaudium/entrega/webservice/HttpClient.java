package br.com.gaudium.entrega.webservice;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    static String BASE_URL = "https://dbgapi-desenv.taximachine.com.br";

    public static Retrofit retrofit() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



}
