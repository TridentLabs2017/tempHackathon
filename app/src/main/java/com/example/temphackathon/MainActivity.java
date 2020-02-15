package com.example.temphackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IBMdatabase ibm = null;
                try {
                    ibm = new IBMdatabase();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
//                ibm.createIBMDatabase();
                ibm.insertIntoIBMDatabse();
            }
        });
    }


}
