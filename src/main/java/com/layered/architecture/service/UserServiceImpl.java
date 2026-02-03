package com.layered.architecture.service;

import com.layered.architecture.service.adapters.UserPersistenceAdapter;
import com.layered.architecture.service.model.UserCreationModel;
import com.layered.architecture.service.model.UserData;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

//    private UserPersistenceAdapter userPersistenceAdapter;
    @Override
    public UserData create(UserCreationModel model) {

//        Object user;
//        UUID userId = userPersistenceAdapter.createUser(user);


        return new UserData(
                UUID.fromString("5445bd2c-5f80-400b-a19b-74eb12a0efcc"),
                model.personal(),
                model.contacts()
        );
    }
}
