package com.prsoftware.api.dtos.usuario;

public record UsuarioRequestAdmin(
        String nome,
        String email,
        String senha,
        RoleUsuario role
) {
}
