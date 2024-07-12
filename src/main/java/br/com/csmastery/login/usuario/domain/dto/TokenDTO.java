package br.com.csmastery.login.usuario.domain.dto;

import lombok.Builder;

@Builder
public record TokenDTO(

        String token,

        String type,

        String login,

        String role
) {
}
