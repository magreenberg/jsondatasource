package com.bh.jsondatasource.api;

import java.util.ArrayList;
import java.util.List;


public class UserList {
    private List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    
   
}
