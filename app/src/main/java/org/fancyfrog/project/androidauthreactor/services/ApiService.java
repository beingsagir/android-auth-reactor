package org.fancyfrog.project.androidauthreactor.services;

import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sagir on 9/27/2017.
 */

public class ApiService {


    String API_BASE_URL = "https://reqres.in/";

    public Call<Object> getLogin(String username, String password){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(httpClient.build()).build();

        AuthClient client =  retrofit.create(AuthClient.class);

        // Fetch a list of the Github repositories.
        return  client.login(username, password);


       // return call;

    }




}
