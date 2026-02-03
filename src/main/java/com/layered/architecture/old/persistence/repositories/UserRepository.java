package com.layered.architecture.old.persistence.repositories;

import com.layered.architecture.old.entities.User;
import com.layered.architecture.old.models.UserCreationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUsersById(Integer id);

    UserCreationModel findUserModelById(int id);
}
