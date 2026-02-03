package com.layered.architecture.old.services;

import com.layered.architecture.old.persistence.adaptors.UserAdapter;
import com.layered.architecture.old.persistence.adaptors.UserAdaptorImpl;
import com.layered.architecture.old.entities.User;
import com.layered.architecture.old.persistence.repositories.UserRepository1;

import java.util.List;


//@Service
public class UserService {

    private final UserAdapter userAdaptor;
    private final UserRepository1 userRepository1;
    public UserService(UserAdaptorImpl userAdaptor, UserRepository1 userRepository1){
        this.userAdaptor=userAdaptor;
        this.userRepository1 = userRepository1;
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
        return List.of();
//        return userRepository1.findAll();
    }

    public User getUser(int id) {
        return userRepository1.findUsersById(id);
    }

//    public void updateFeedback(int id, UserPersonalInfo info) {
//        UserCreationModel userCreationModel = userRepository.findUserModelById(id);     //Here I am confused that the User entity should not be updated directly but how to find the user??
////        userCreationModel.setFeedback(info.getFeedback());
////        User user=userAdaptor.toEntity(userCreationModel);
//        userRepository.save(user);
//    }
}
