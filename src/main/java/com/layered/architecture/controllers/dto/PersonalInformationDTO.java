package com.layered.architecture.controllers.dto;

import java.time.LocalDate;

public record PersonalInformationDTO(
        String fullName,
        Gender gender,
        LocalDate birthDate
) {
    public enum Gender {
        MALE, FEMALE, NOT_DISCLOSED
    }
}
