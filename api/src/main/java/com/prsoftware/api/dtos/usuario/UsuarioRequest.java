package com.prsoftware.api.dtos;

public record UsuarioRequest(
        String nome,
        String email,
        String senha,

        RoleUsuario role
) {
}
