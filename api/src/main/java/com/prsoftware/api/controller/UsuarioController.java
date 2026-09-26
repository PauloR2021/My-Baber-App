package com.prsoftware.api.controller;

import com.prsoftware.api.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
