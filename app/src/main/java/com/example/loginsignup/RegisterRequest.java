package com.example.loginsignup;

public class RegisterRequest
{
    private String fullName;
    private String email;
    private String password;
    private String role;
    private int isGoogleAuth=0;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIsGoogleAuth() {
        return isGoogleAuth;
    }

    public void setIsGoogleAuth(int isGoogleAuth) {
        this.isGoogleAuth = isGoogleAuth;
    }
}