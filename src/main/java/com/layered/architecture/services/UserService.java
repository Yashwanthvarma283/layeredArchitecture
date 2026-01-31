package com.layered.architecture.services;

import com.layered.architecture.adaptors.UserAdaptor;
import com.layered.architecture.entities.User;
import com.layered.architecture.models.CreateUser;
import com.layered.architecture.models.UserModel;
import com.layered.architecture.models.UserPersonalInfo;
import com.layered.architecture.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class UserService {

    private final UserAdaptor userAdaptor;
    private final UserRepo userRepo;
    public UserService(UserAdaptor userAdaptor,UserRepo userRepo){
        this.userAdaptor=userAdaptor;
        this.userRepo=userRepo;
    }

    public void createUser(CreateUser newUser){
        UserModel user=new UserModel();
        user.setAge(newUser.getAge());
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        int id;
        do{
            id= ThreadLocalRandom.current().nextInt(1000,9999);
        }
        while(userRepo.existsById(id));
        user.setId(id);

        User addUser=userAdaptor.toEntity(user);
        userRepo.save(addUser);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getUser(int id) {
        return userRepo.findUsersById(id);
    }

    public void updateFeedback(int id, UserPersonalInfo info) {
        UserModel userModel=userRepo.findUserModelById(id);     //Here I am confused that the User entity should not be updated directly but how to find the user??
        userModel.setFeedback(info.getFeedback());
        User user=userAdaptor.toEntity(userModel);
        userRepo.save(user);
    }
}
