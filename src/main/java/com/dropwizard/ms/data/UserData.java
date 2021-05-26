package com.dropwizard.ms.data;

import java.util.HashMap;
import java.util.Map;

import com.dropwizard.ms.api.UserDetails;

public class UserData {

    private static Map<Integer, UserDetails> userDataSource = new HashMap<>();

    static void configure() {
        setUserData(new UserDetails(1, "John", "john1"));
        setUserData(new UserDetails(2, "John", "john2"));
        setUserData(new UserDetails(3, "John", "john3"));
        setUserData(new UserDetails(4, "John", "john4"));
    }

    static {
        configure();
    }

    public static UserDetails getUserData(Integer id) {
        return userDataSource.get(id);
    }

    static void setUserData(UserDetails userData) {
        userDataSource.putIfAbsent(userData.getId(), userData);
    }
}
