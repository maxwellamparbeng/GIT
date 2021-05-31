package com.dbconnect.dbconnect.controller;

import com.dbconnect.dbconnect.Model.User;
import com.dbconnect.dbconnect.repository.UserRepository;
import com.dbconnect.dbconnect.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)

public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService u;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {

        User n = new User();
//        n.setName(name);
//        n.setEmail(email);

        n.setName("name");
        n.setEmail("email");

        u.adduser(n);


        //userRepository.save(n);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users


        return u.allUsers();

        //return userRepository.findAll();
    }


    @PostMapping (path="/postbody")
    public @ResponseBody
    String postBody(@RequestBody User user)  {

        User n = new User();

        var email =user.getEmail();
        var name =  user.getName();
        n.setName(name);
        n.setEmail(email);


        u.adduser(n);

        userRepository.save(n);

        return "saved";


    }


}