package com.prsoftware.api.dtos.usuario;

public record ResponseUsuario(
        Long id,
        String nome,
        String email,
        String role
) {
}
