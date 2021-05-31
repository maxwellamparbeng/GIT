package com.dbconnect.dbconnect.service;

import com.dbconnect.dbconnect.Model.User;
import com.dbconnect.dbconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements Iuser {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<User> allUsers() {

       return  userRepository.findAll();
    }

    @Override
    public void adduser(User user) {

        userRepository.save(user);
    }
}
