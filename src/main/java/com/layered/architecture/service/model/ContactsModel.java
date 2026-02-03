package com.layered.architecture.service.model;

import lombok.Builder;

@Builder
public record ContactsModel(
        String email, String mobile
) {
}
