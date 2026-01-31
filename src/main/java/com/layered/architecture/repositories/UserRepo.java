package com.layered.architecture.repositories;

import com.layered.architecture.entities.User;
import com.layered.architecture.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findUsersById(Integer id);

    UserModel findUserModelById(int id);
}
