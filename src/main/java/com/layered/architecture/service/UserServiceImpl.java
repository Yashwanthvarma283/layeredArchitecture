package com.layered.architecture.service;

import com.layered.architecture.service.adapters.ContactsPersistenceModel;
import com.layered.architecture.service.adapters.PersonalDataPersistenceModel;
import com.layered.architecture.service.adapters.UserPersistenceAdapter;
import com.layered.architecture.service.adapters.UserPersistenceModel;
import com.layered.architecture.service.model.Gender;
import com.layered.architecture.service.model.UserCreationModel;
import com.layered.architecture.service.model.UserData;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserPersistenceAdapter userPersistenceAdapter;

    public UserServiceImpl(UserPersistenceAdapter userPersistenceAdapter) {
        this.userPersistenceAdapter = userPersistenceAdapter;
    }

    @Override
    public UserData create(UserCreationModel model) {

        PersonalDataPersistenceModel.Gender gender = switch (model.personal().gender()){
            case Male -> PersonalDataPersistenceModel.Gender.MALE;
            case Female -> PersonalDataPersistenceModel.Gender.FEMALE;
            case Others -> PersonalDataPersistenceModel.Gender.OTHER;
        };
        UserPersistenceModel user = UserPersistenceModel.builder()
                .contacts(ContactsPersistenceModel.builder()
                        .email(model.contacts().email())
                        .mobile(model.contacts().mobile())
                        .build())
                .personal(PersonalDataPersistenceModel.builder()
                        .name(model.personal().name())
                        .gender(gender)
                        .birthDate(model.personal().birthDate())
                        .build())
                .build();
        UUID userId = userPersistenceAdapter.createUser(user);


        return new UserData(
                userId,
                model.personal(),
                model.contacts()
        );
    }
}
