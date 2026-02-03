package com.layered.architecture.service.adapters;

import com.layered.architecture.service.model.Gender;

import java.time.LocalDate;

public record Personal(
        String name,
        Gender gender,
        LocalDate birthDate
) {
}
