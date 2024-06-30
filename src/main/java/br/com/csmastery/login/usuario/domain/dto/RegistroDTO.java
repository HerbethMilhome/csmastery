package br.com.csmastery.login.usuario.domain.dto;

import br.com.csmastery.login.usuario.enums.UsuarioRole;
import jakarta.validation.constraints.NotNull;

public record RegistroDTO(

        @NotNull
        String login,

        @NotNull
        String senha,

        UsuarioRole role
) {
}
