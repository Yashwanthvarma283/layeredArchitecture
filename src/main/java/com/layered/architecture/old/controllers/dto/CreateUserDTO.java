package com.layered.architecture.old.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
    String name;
    String email;
    Integer age;
}
