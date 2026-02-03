package com.layered.architecture.controllers.dto;

import java.time.LocalDate;

public record CreateUserDTO(
        PersonalInformationDTO personalInformation,
        ContactsDTO contacts

) {
}
