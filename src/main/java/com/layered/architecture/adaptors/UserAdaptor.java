package com.layered.architecture.adaptors;

import com.layered.architecture.entities.User;
import com.layered.architecture.models.UserModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserAdaptor {

    public User toEntity(UserModel user) {
        User addUser=new User();
        addUser.setAge(user.getAge());
        addUser.setId(user.getId());
        addUser.setEmail(user.getEmail());
        addUser.setName(user.getName());
        addUser.setTime(LocalDateTime.now());
        return addUser;
    }
}
