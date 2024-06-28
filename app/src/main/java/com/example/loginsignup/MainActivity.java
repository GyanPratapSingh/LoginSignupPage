package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LoginResponse loginResponse;
    TextView User_Details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        User_Details = findViewById(R.id.User_Details);
        Intent intent = getIntent();
        if(intent.getExtras() !=null)
        {
            loginResponse =(LoginResponse) intent.getSerializableExtra("data");
            User_Details.setText(loginResponse.getData().getEmail());


            Log.e("TAG", "=======>"+loginResponse.getData());
        }


    }
    }
