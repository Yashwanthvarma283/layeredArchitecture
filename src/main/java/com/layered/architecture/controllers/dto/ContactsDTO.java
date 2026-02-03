package com.layered.architecture.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// Serialization to json or deserialization  from json
// majority of simple validations
// Different rules for convertign json values in objects
public record ContactsDTO(
        @JsonProperty("email")
        String email,
        @JsonProperty("mobile")
        String mobile) {
}
