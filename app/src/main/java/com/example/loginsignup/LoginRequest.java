package com.example.loginsignup;

public class LoginRequest {
    private String email;
    private String password;
    private String isGoogleAuth;

    public String getEmail() { return email;  }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsGoogleAuth() {
        return isGoogleAuth;
    }

    public void setIsGoogleAuth(String isGoogleAuth) {
        this.isGoogleAuth = isGoogleAuth;
    }
}
