package com.layered.architecture.old.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreationModel {
    String name;
    String email;
    Integer age;
}
