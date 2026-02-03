package com.layered.architecture.service.model;

import java.util.UUID;

public record UserData(
        UUID id,
        PersonalDataModel personalData,
        ContactsModel contacts
) {
}
