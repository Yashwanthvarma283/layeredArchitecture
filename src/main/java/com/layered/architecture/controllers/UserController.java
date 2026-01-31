package com.layered.architecture.controllers;


import com.layered.architecture.entities.User;
import com.layered.architecture.models.CreateUser;
import com.layered.architecture.models.UserPersonalInfo;
import com.layered.architecture.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/create/user")
    public ResponseEntity<String> createUser(@RequestBody CreateUser newUser){
        userService.createUser(newUser);
        return ResponseEntity.ok("Donor Created");
    }

    @GetMapping("get/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("get/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PutMapping("feedback/{id}")
    public ResponseEntity<String> addFeedback(@PathVariable int id, @RequestBody UserPersonalInfo info){
        userService.updateFeedback(id,info);
        return ResponseEntity.ok("Feedback added");
    }

}
