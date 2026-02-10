package com.layered.architecture.persistence;

import com.layered.architecture.persistence.entities.GenderDb;
import com.layered.architecture.persistence.entities.User;
import com.layered.architecture.service.adapters.UserPersistenceModel;
import com.layered.architecture.service.adapters.UserPersistenceAdapter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class UserPersistenceAdapterImpl implements UserPersistenceAdapter {

    private final UserRepository repository;

    public UserPersistenceAdapterImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID createUser(UserPersistenceModel user) {

        UUID uuid = UUID.randomUUID();
        User entity = new User();
        entity.setUuid(uuid);
        entity.setEmail(user.contacts().email());
        entity.setMobile(user.contacts().mobile());
        entity.setName(user.personal().name());
        entity.setBirthDate(user.personal().birthDate());
        GenderDb gender = switch (user.personal().gender()){
            case MALE -> GenderDb.male;
            case FEMALE -> GenderDb.female;
            case OTHER -> GenderDb.other;
        };
        entity.setGender(gender);

        repository.save(entity);

        return uuid;
    }
}
