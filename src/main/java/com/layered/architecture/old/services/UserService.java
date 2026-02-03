package com.layered.architecture.old.services;

import com.layered.architecture.old.persistence.adaptors.UserAdapter;
import com.layered.architecture.old.persistence.adaptors.UserAdaptorImpl;
import com.layered.architecture.old.entities.User;
import com.layered.architecture.old.controllers.dto.CreateUserDTO;
import com.layered.architecture.old.models.UserCreationModel;
import com.layered.architecture.old.models.UserPersonalInfo;
import com.layered.architecture.old.persistence.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class UserService {

    private final UserAdapter userAdaptor;
    private final UserRepository userRepository;
    public UserService(UserAdaptorImpl userAdaptor, UserRepository userRepository){
        this.userAdaptor=userAdaptor;
        this.userRepository = userRepository;
    }
//
//    public void createUser(CreateUserDTO newUser){
//        userAdaptor.saveUser();
//
//        int id;
//        do{
//            id= ThreadLocalRandom.current().nextInt(1000,9999);
//        }
//        while(userRepository.existsById(id));
//        user.setId(id);
//
//        User addUser=userAdaptor.toEntity(user);
//        userRepository.save(addUser);
//    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findUsersById(id);
    }

//    public void updateFeedback(int id, UserPersonalInfo info) {
//        UserCreationModel userCreationModel = userRepository.findUserModelById(id);     //Here I am confused that the User entity should not be updated directly but how to find the user??
////        userCreationModel.setFeedback(info.getFeedback());
////        User user=userAdaptor.toEntity(userCreationModel);
//        userRepository.save(user);
//    }
}
