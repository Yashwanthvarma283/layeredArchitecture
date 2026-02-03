package com.layered.architecture.old.controllers;


import com.layered.architecture.old.entities.User;
import com.layered.architecture.old.controllers.dto.CreateUserDTO;
import com.layered.architecture.old.models.UserCreationModel;
import com.layered.architecture.old.models.UserPersonalInfo;
import com.layered.architecture.old.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Mapping
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/create/user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserDTO newUser){

        UserCreationModel model = new UserCreationModel(newUser.getName(), newUser.getEmail(), newUser.getAge());
        userService.createUser(model);
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
