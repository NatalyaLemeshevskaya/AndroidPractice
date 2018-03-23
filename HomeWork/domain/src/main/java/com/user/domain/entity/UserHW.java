package com.user.domain.entity;

public class UserHW {

    private  String firstName;
    private  String lastName;
    private  int age;
    private  String sex;

    public UserHW(String firstName, String lastName, int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
