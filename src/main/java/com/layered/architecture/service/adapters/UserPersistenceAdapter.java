package com.layered.architecture.service.adapters;

import java.util.UUID;

public interface UserPersistenceAdapter {
    UUID createUser(UserPersistenceModel user);
}
