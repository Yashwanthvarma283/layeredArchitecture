package com.layered.architecture.service.adapters;

import lombok.Builder;

@Builder
public record ContactsPersistenceModel(String email, String mobile) {
}
