package com.dh.aula33.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "tb_jogador")
public class Jogador{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String posicao;
    private Double peso;
    private Double altura;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    public Jogador() {
    }

    public Jogador(String nome, String posicao, Double peso, Double altura, Time time) {
        this.nome = nome;
        this.posicao = posicao;
        this.peso = peso;
        this.altura = altura;
        this.time = time;
    }

    public Jogador(Long id, String nome, String posicao, Double peso, Double altura, Time time) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.peso = peso;
        this.altura = altura;
        this.time = time;
    }
}
