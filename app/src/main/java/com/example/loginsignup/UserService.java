package com.example.loginsignup;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("Login/")
    Call<LoginResponse>loginUser(@Body LoginRequest loginRequest);

    @POST("Register/")
    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);
}
