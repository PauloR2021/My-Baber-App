package com.prsoftware.api.entity;

import com.prsoftware.api.dtos.agendamento.StatusAgendamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Agendamento_tb")
@Getter
@Setter
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_USUARIO",nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "DATA")
    private LocalDate data;
    @Column(name = "HORARIO")
    private LocalTime horario;

    @Column(name = "ATIVIDADEs")
    private String atividade;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",nullable = false)
    private StatusAgendamento status =  StatusAgendamento.AGENDADO;

}
