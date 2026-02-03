package com.layered.architecture.old.persistence.adaptors;

import com.layered.architecture.old.entities.User;
import com.layered.architecture.old.models.UserCreationModel;
import com.layered.architecture.old.persistence.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;


@Component
public class UserAdaptorImpl implements UserAdapter {



    private UserRepository repository;




//    public static User toEntity(UserCreationModel user) {
//        User addUser=new User();
//        addUser.setAge(user.getAge());
//        addUser.setId(user.getId());
//        addUser.setEmail(user.getEmail());
//        addUser.setName(user.getName());
//        addUser.setTime(LocalDateTime.now());
//        return addUser;
//    }

    @Override
    public void saveUser(UserCreationModel userCreationModel) {
//        UserCreationModel user=new UserCreationModel();
//        user.setAge(newUser.getAge());
//        user.setName(newUser.getName());
//        user.setEmail(newUser.getEmail());
//        int id;
//        do{
//            id= ThreadLocalRandom.current().nextInt(1000,9999);
//        }
//        while(userRepository.existsById(id));
//        user.setId(id);
//
//        User addUser=userAdaptor.toEntity(user);
//        userRepository.save(addUser);
    }
}
