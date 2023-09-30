package com.example.sqlitetutorial;

public class Details {

    String rollno,name,age,phonenumber,email,gender,address;
    public Details(){

    }

    public Details(String rollno, String name, String age, String phonenumber, String email, String gender, String address) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.phonenumber = phonenumber;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
