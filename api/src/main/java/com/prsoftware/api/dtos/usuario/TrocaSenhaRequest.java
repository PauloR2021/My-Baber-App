package com.prsoftware.api.dtos.usuario;

public record TrocaSenhaRequest(
        String email,
        String senha
) {
}
