package org.fancyfrog.project.androidauthreactor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.fancyfrog.project.androidauthreactor.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username   = (EditText)findViewById(R.id.username);
        EditText password   = (EditText)findViewById(R.id.password);

        ApiService apiService = new ApiService();
        Call<Object> call = apiService.getLogin(username.toString(), password.toString());


        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d("res", response.body().toString());
                TextView myAwesomeTextView = (TextView)findViewById(R.id.token);
                myAwesomeTextView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                System.out.println("Error");
                Log.d("res", t.getLocalizedMessage());
            }
        });

    }
}
