package com.prsoftware.api.entity;

import com.prsoftware.api.dtos.usuario.RoleUsuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;

@Entity
@Table(name = "USUARIO_TB")
@Getter
@Setter
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "EMAIL",nullable = false, unique = true)
    private String email;

    @Column(name = "SENHA",nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private RoleUsuario role;


}
