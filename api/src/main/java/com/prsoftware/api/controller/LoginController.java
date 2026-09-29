package com.prsoftware.api.controller;

import com.prsoftware.api.dtos.LoginRequest;
import com.prsoftware.api.dtos.usuario.ResponseUsuario;
import com.prsoftware.api.dtos.usuario.UsuarioRequest;
import com.prsoftware.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(
        name = "Autenticação",
        description = "Endpoints para autenticação e cadastro de usuários"
)
public class LoginController {

    private final UsuarioService usuarioService;
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



    @Operation(
            summary = "Cadastrar usuário",
            description = "Cadastra um novo usuário no sistema"
    )
    @PostMapping("/register")
    public ResponseEntity<ResponseUsuario> cadastrar(@RequestBody UsuarioRequest request) {
        ResponseUsuario usuario = usuarioService.novoUsuario(request);

        return ResponseEntity.ok(usuario);
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
