package com.dh.aula33.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JogadorDTO {

    private Long id;
    private String nome;
    private String posicao;
    private Double peso;
    private Double altura;
    private Long time;

    public JogadorDTO() {
    }

    public JogadorDTO(String nome, String posicao, Double peso, Double altura, Long time) {
        this.nome = nome;
        this.posicao = posicao;
        this.peso = peso;
        this.altura = altura;
        this.time = time;
    }

    public JogadorDTO(Long id, String nome, String posicao, Double peso, Double altura, Long time) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.peso = peso;
        this.altura = altura;
        this.time = time;
    }
}
