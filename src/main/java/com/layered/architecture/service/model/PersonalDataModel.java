package com.layered.architecture.service.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PersonalDataModel(
        String name,
        Gender gender,
        LocalDate birthDate

) {

}
