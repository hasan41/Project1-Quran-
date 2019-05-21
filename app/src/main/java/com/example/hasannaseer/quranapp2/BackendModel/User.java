package com.example.hasannaseer.quranapp2.BackendModel;

public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String password;



    public User() {
    }

    public User(String firstName, String lastName, String username, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastNameName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.firstName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}