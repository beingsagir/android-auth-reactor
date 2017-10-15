package org.fancyfrog.project.androidauthreactor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.fancyfrog.project.androidauthreactor.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String jwtToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button clickButton = (Button) findViewById(R.id.login);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ApiService apiService = new ApiService();

                EditText username   = (EditText)findViewById(R.id.username);
                EditText password   = (EditText)findViewById(R.id.password);

                Call<Object> call = apiService.getLogin(username.getText().toString(), password.getText().toString());

                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Log.d("res", response.body().toString());
                        //TextView myAwesomeTextView = (TextView)findViewById(R.id.token);
                        //myAwesomeTextView.setText(response.body().toString());
                        jwtToken = response.body().toString();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        System.out.println("Error");
                        Log.d("res", t.getLocalizedMessage());
                    }
                });

                printJWT(jwtToken);

            }
        });



    }

    private void printJWT(String jwtToken) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("passedjwt", jwtToken);
            startActivity(intent);

    }
}
