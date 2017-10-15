package org.fancyfrog.project.androidauthreactor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("passedjwt");
        TextView txtView = (TextView) findViewById(R.id.token);
        txtView.setText(message);
    }
}
