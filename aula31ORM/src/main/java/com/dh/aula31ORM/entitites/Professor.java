package com.dh.aula31ORM.entitites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String curso;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private Set<Aluno> alunos = new HashSet<>();


    public Professor() {
    }


}
