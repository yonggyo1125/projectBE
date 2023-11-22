package org.koreait.api.controllers.members;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RequestLogin(
        @NotBlank
        String email,
        @NotBlank
        String password
) {}
