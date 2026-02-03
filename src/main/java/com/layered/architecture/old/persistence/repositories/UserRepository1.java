package com.layered.architecture.old.persistence.repositories;

import com.layered.architecture.old.entities.User;
import com.layered.architecture.old.models.UserCreationModel;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
public interface UserRepository1 {
    User findUsersById(Integer id);

    UserCreationModel findUserModelById(int id);
}
