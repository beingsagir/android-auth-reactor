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

    public void getLogin(){

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
        Call<Object> call =
                client.login();

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                // The network call was a success and we got a response
                //System.out.println(response.body());
                Log.d("res", response.body().toString());
                // TODO: use the repository list and display it
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

                System.out.println("Error");
                Log.d("res", t.getLocalizedMessage());
                // the network call was a failure
                // TODO: handle error
            }
        });
    }


}
