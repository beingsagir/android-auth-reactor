package org.fancyfrog.project.androidauthreactor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.fancyfrog.project.androidauthreactor.services.ApiService;
import org.fancyfrog.project.androidauthreactor.services.AuthClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = new ApiService();
    }
}
