package com.paint_nest_mobile.paintnestapp;

public class Storingdata {
    String username,password,email,contact;

    public Storingdata() {
    }

    public Storingdata(String username, String password, String email, String contact) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
