package com.prsoftware.api.controller;

import com.prsoftware.api.dtos.usuario.ResponseUsuario;
import com.prsoftware.api.dtos.usuario.TrocaSenhaRequest;
import com.prsoftware.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(
        name = "Acesso User",
        description = "Endpoints para quem tem acesso user"
)
public class UsuarioController {
    private final UsuarioService usuarioService;

    public  UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/my-user")
    public ResponseEntity<ResponseUsuario> myUser( @RequestParam String email) {
        ResponseUsuario usuario = usuarioService.meuPerfil(email);

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/trocar-senha")
    public ResponseEntity<ResponseUsuario> trocarSenha(@RequestBody TrocaSenhaRequest request) {
        ResponseUsuario usuario = usuarioService.trocarSenha(request);

        return ResponseEntity.ok(usuario);
    }


}
