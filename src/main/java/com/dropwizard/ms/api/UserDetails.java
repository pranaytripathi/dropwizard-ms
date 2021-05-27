package com.dropwizard.ms.api;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {

    private String name, userName;
    private Integer id;


    public UserDetails(Integer id, String name, String userName) {
        this.id = id;
        this.name = name;
        this.userName = userName;
    }

    @JsonProperty
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
