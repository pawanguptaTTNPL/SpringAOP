package com.example.SpringAOP.controllers;

import com.example.SpringAOP.entities.User;
import com.example.SpringAOP.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    Userservice userservice;
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id)  {
//        throw new Exception("LLLL");
        User user=userservice.getUser(id);
        if(user==null)
            return null;
        else
            return user;
    }

}