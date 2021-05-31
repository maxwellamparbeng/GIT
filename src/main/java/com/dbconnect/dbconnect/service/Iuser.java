package com.dbconnect.dbconnect.service;

import com.dbconnect.dbconnect.Model.User;

public interface Iuser {

    Iterable<User> allUsers();

    void adduser(User user);

}
