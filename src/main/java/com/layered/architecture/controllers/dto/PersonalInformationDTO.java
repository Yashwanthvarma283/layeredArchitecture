package com.layered.architecture.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PersonalInformationDTO(
        @JsonProperty("fullName")
        String fullName,
        @JsonProperty("gender")
        Gender gender,
        @JsonProperty("birthDate")
        LocalDate birthDate
) {
    public enum Gender {
        MALE, FEMALE, NOT_DISCLOSED
    }
}
