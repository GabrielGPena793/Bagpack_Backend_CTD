package com.dh.aula31Conclusao.entitites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "tabela_mascote")
public class Mascote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Integer idade;

    public Mascote() {
    }

    public Mascote(Integer id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Mascote(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

}
