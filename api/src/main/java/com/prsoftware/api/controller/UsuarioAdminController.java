package com.prsoftware.api.controller;

import com.prsoftware.api.dtos.usuario.ResponseUsuario;
import com.prsoftware.api.dtos.usuario.UsuarioRequest;
import com.prsoftware.api.dtos.usuario.UsuarioRequestAdmin;
import com.prsoftware.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Tag(
        name = "Acesso Admin",
        description = "Endpoints para quem tem acesso Admin"
)
public class UsuarioAdminController {
    private final UsuarioService usuarioService;

    public UsuarioAdminController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Operation(
            summary = "Cadastrar usuário",
            description = "Cadastra um novo usuário no sistema"
    )
    @PostMapping("/register")
    public ResponseEntity<ResponseUsuario> cadastrar(@RequestBody UsuarioRequestAdmin request) {
        ResponseUsuario usuario = usuarioService.novoUsuarioAdmin(request);

        return ResponseEntity.ok(usuario);
    }
}
