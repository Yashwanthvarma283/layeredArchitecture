package com.layered.architecture.service.model;

import lombok.Builder;

@Builder
public record UserCreationModel(
        PersonalDataModel personal,
        ContactsModel contacts
) {
}
