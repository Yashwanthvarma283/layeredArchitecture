package com.layered.architecture.service.adapters;

import lombok.Builder;

@Builder
public record UserPersistenceModel(PersonalDataPersistenceModel personal, ContactsPersistenceModel contacts) {

}
