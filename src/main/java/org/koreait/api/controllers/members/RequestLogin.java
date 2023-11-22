package org.koreait.api.controllers.members;

import jakarta.validation.constraints.NotBlank;

public record RequestLogin(
        @NotBlank
        String email,
        @NotBlank
        String password
) {}
