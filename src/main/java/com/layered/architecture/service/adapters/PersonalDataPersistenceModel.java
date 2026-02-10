package com.layered.architecture.service.adapters;

import com.layered.architecture.service.model.Gender;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PersonalDataPersistenceModel(
        String name,
        Gender gender,
        LocalDate birthDate
) {
    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
