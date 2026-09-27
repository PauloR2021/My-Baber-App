package com.prsoftware.api.dtos.usuario;

public record UsuarioRequest(
        String nome,
        String email,
        String senha
) {
}
