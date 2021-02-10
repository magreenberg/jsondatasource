package com.bh.jsondatasource.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    // public String getName() {
    //     return user_name;
    // }

    // public void setName(String user_name) {
    //     this.user_name = user_name;
    // }
       
}
