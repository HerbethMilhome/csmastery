package br.com.csmastery.login.usuario.domain.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(

        @NotNull
        String login,
        @NotNull
        String senha
) {
}
