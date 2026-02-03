package com.layered.architecture.controllers;

import com.layered.architecture.controllers.dto.CreateUserDTO;
import com.layered.architecture.controllers.dto.UserCreationResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public UserCreationResponseDTO create(CreateUserDTO user){
        return new UserCreationResponseDTO(UUID.fromString("5445bd2c-5f80-400b-a19b-74eb12a0efcc"));
    }

}
