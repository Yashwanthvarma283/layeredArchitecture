package com.layered.architecture.service;

import com.layered.architecture.service.model.UserCreationModel;
import com.layered.architecture.service.model.UserData;

public interface UserService {

    UserData create(UserCreationModel model);
}
