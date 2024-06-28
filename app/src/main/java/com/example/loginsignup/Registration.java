package com.example.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity
{
    EditText editTextEmail, editTextPassword, editTextusername,editTextrole ;

    int isGoogleAuth = 0;
    Button buttonReg;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextEmail = findViewById(R.id.email);
        editTextusername = findViewById(R.id.UserName);
        editTextrole = findViewById(R.id.Role);
        editTextPassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.btn_Register);
        textView = findViewById(R.id.loginNow);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(editTextEmail.getText().toString()) || TextUtils.isEmpty(editTextPassword.getText().toString()) ||TextUtils.isEmpty(editTextrole.getText().toString()) || TextUtils.isEmpty(editTextusername.getText().toString()))
                {
                    String message = "All inputs Required...";
                    Toast.makeText(Registration.this,message,Toast.LENGTH_LONG).show();

                }
                else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setEmail(editTextEmail.getText().toString());
                    registerRequest.setPassword(editTextPassword.getText().toString());
                    registerRequest.setRole(editTextrole.getText().toString());
                    registerRequest.setFullName(editTextusername.getText().toString());
                    registerRequest.setIsGoogleAuth(isGoogleAuth);
                    registerUser(registerRequest);
                }


                String email, password, Role, UserName;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                Role = String.valueOf((editTextrole.getText()));
                UserName = String.valueOf(editTextusername.getText());


                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Registration.this, "Enter UserName", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Registration.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(Role)){
                    Toast.makeText(Registration.this, "Enter Role", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(UserName)){
                    Toast.makeText(Registration.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }


            }

        });

    }
    public void registerUser(RegisterRequest registerRequest)
    {
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUsers(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {

            @Override
            public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {


                if(response.isSuccessful()){
                    String message = "Successful...";
                    Toast.makeText(Registration.this,message,Toast.LENGTH_LONG).show();

                    startActivity(new Intent(Registration.this,Login.class));
                    finish();


                }else{
                    String message = "An error occurred please try again later....";
                    Toast.makeText(Registration.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(Registration.this,message,Toast.LENGTH_LONG).show();


            }
        });

    }



}