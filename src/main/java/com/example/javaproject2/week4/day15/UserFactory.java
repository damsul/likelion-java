package com.example.javaproject2.week4.day15;

public class UserFactory {

    public User getAdultUser() {
        User user = new User();
        user.setAge(34);
        return user;
    }
}
