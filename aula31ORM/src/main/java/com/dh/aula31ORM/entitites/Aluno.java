package com.dh.aula31ORM.entitites;

import javax.persistence.*;

@Entity
@Table
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Aluno() {
    }
}
