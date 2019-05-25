package com.example.medconnect;

import android.widget.EditText;

import com.google.firebase.database.ValueEventListener;

public class Users {

    private String firstname,email,insuranceid,emiratedid,phonenumber,gender,password,address1,address2;


    public Users(){

    }


    public Users(String firstname, String email, String insuranceid, String emiratedid, String phonenumber, String gender,String password,String address1,String address2) {
        this.firstname = firstname;
        this.email = email;
        this.insuranceid = insuranceid;
        this.emiratedid = emiratedid;
        this.phonenumber = phonenumber;
        this.password = password;
        this.gender = gender;
        this.address1 = address1;
        this.address2 = address2;
    }

    public static void addListenerForSingValueEvent(ValueEventListener valueEventListener) {
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getInsuranceid(){
        return insuranceid;
    }

    public void setInsuranceid(String insuranceid){
        this.insuranceid = insuranceid;
    }

    public String getEmiratedid(){
        return emiratedid;
    }

    public void setEmiratedid(String emiratedid){
        this.emiratedid = emiratedid;
    }

    public String getPhonenumber(){
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getAddress1(){
        return address1;
    }

    public void setAddress1(String address1){
        this.address1 = address1;
    }

    public String getAddress2(){
        return address2;
    }

    public void setAddress2(String address2){
        this.address2 = address2;
    }
}
