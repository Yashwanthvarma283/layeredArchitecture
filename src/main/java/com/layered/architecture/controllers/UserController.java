package com.layered.architecture.controllers;

import com.layered.architecture.controllers.dto.CreateUserDTO;
import com.layered.architecture.controllers.dto.UserCreationResponseDTO;
import com.layered.architecture.service.UserService;
import com.layered.architecture.service.model.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping
    public UserCreationResponseDTO create(@RequestBody CreateUserDTO user){


        // response model = userService.create(... creation model ...)
        Gender gender = switch(user.personalInformation().gender()){
            case MALE -> Gender.Male;
            case FEMALE -> Gender.Female;
            case NOT_DISCLOSED -> Gender.Others;
        };
        UserCreationModel model = UserCreationModel.builder()
                .personal(PersonalDataModel.builder()
                        .name(user.personalInformation().fullName())
                        .birthDate(user.personalInformation().birthDate())
                        .gender(gender)
                        .build())
                .contacts(ContactsModel.builder()
                        .email(user.contacts().email())
                        .mobile(user.contacts().mobile())
                        .build())
                .build();
        UserData userData = userService.create(model);

        return new UserCreationResponseDTO(userData.id());
    }

}
