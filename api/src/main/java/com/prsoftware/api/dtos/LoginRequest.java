package com.prsoftware.api.dtos;

public record LoginRequest(
        String email,
        String senha
) {
}
