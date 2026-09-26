package com.prsoftware.api.controller;

import com.prsoftware.api.dtos.LoginRequest;
import com.prsoftware.api.dtos.ResponseUsuario;
import com.prsoftware.api.dtos.UsuarioRequest;
import com.prsoftware.api.entity.UsuarioEntity;
import com.prsoftware.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@Tag(
        name = "Autenticação",
        description = "Endpoints para autenticação e cadastro de usuários"
)
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(
            summary = "Cadastrar usuário",
            description = "Cadastra um novo usuário no sistema"
    )
    @PostMapping("/register")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioRequest request) {
        usuarioService.novoUsuario(request);
        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }

    @Operation(
            summary = "Realizar login",
            description = "Realiza o login dentro do sistema"
    )
    @PostMapping("/login")
    public ResponseEntity<ResponseUsuario> login(@RequestBody LoginRequest request) {

        ResponseUsuario usuario = usuarioService.login(request);

        return ResponseEntity.ok(usuario);

    }
}
