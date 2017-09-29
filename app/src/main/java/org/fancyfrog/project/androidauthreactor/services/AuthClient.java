package org.fancyfrog.project.androidauthreactor.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sagir on 9/26/2017.
 */



public interface AuthClient {

    @GET("/api/signIn/{username}/{password}")
    Call<Object> login(
            @Path("username") String username, @Path("password") String password
    );
}
