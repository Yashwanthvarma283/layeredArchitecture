package com.layered.architecture.controllers.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.time.LocalDate;

public record CreateUserDTO(
        @JsonUnwrapped
        PersonalInformationDTO personalInformation,
        @JsonUnwrapped
        ContactsDTO contacts

) {
}
