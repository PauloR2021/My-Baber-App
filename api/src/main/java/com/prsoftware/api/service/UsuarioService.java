package com.prsoftware.api.service;

import com.prsoftware.api.dtos.LoginRequest;
import com.prsoftware.api.dtos.usuario.ResponseUsuario;
import com.prsoftware.api.dtos.usuario.RoleUsuario;
import com.prsoftware.api.dtos.usuario.UsuarioRequest;
import com.prsoftware.api.dtos.usuario.UsuarioRequestAdmin;
import com.prsoftware.api.entity.UsuarioEntity;
import com.prsoftware.api.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseUsuario novoUsuarioAdmin(UsuarioRequestAdmin admin) {
        if(usuarioRepository.existsByEmail(admin.email())){
            throw new RuntimeException("Email já cadastrado");
        }

        UsuarioEntity newUsuario = new UsuarioEntity();
        newUsuario.setNome(admin.nome());
        newUsuario.setEmail(admin.email());
        newUsuario.setSenha(passwordEncoder.encode(admin.senha()));
        newUsuario.setRole(admin.role());
        usuarioRepository.save(newUsuario);

        return toResponse(newUsuario);
    }

    public ResponseUsuario novoUsuario(UsuarioRequest usuarioRequest) {
        if(usuarioRepository.existsByEmail(usuarioRequest.email())){
            throw new RuntimeException("Email já cadastrado");
        }

        UsuarioEntity newUsuario = new UsuarioEntity();
        newUsuario.setNome(usuarioRequest.nome());
        newUsuario.setEmail(usuarioRequest.email());
        newUsuario.setSenha(passwordEncoder.encode(usuarioRequest.senha()));
        newUsuario.setRole(RoleUsuario.USER);
        usuarioRepository.save(newUsuario);

        return toResponse(newUsuario);
    }

    public ResponseUsuario login (LoginRequest loginRequest) {
        UsuarioEntity usuario = usuarioRepository
                .findByEmail(loginRequest.email())
                .orElseThrow(
                        () -> new RuntimeException("E-mail não encontrado")
                );

        boolean senha = passwordEncoder.matches(loginRequest.senha(), usuario.getSenha());

        if(!senha){
            throw new RuntimeException("Senha incorreta");
        }

        return toResponse(usuario);
    }

    private ResponseUsuario toResponse  (UsuarioEntity usuario){
        usuario.setId( usuario.getId() );
        usuario.setNome(usuario.getNome());
        usuario.setEmail(usuario.getEmail());
        usuario.setRole(usuario.getRole());
        return new ResponseUsuario(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRole().toString());

    }


}
