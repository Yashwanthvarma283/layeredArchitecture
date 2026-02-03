package com.layered.architecture.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record UserCreationResponseDTO(
        @JsonProperty("id")
        UUID uuid
) {
}
