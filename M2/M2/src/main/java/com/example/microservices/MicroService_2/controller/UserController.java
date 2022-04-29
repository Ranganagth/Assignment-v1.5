package com.example.microservices.MicroService_2.controller;

import com.example.microservices.MicroService_2.entity.User;
import com.example.microservices.MicroService_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping("/get/{val}")
    public User Details(@PathVariable String val) {
        return service.getUserByDevice_id(val);
    }
    @PostMapping("/login")
    public User addUser(@RequestBody User user) {
        String data = user.getDevice_id();
        System.out.println(data);
        //System.out.println(user.toString());
        return service.saveUser(user);

    }

}