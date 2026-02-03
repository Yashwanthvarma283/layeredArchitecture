package com.layered.architecture.persistence;

import com.layered.architecture.service.adapters.UserData;
import com.layered.architecture.service.adapters.UserPersistenceAdapter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserPersistenceAdapterImpl implements UserPersistenceAdapter {
    @Override
    public UUID createUser(UserData user) {
        return null;
    }
}
