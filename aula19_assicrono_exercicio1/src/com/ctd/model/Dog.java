package com.ctd.model;

import java.io.Serializable;

public class Dog implements Serializable {

    private String nome, raça, endereço;
    private int idade;

    public Dog(String nome, String raça, String endereço, int idade) {
        this.nome = nome;
        this.raça = raça;
        this.endereço = endereço;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", raça='" + raça + '\'' +
                ", idade ='" + idade  + '\'' +
                ", endereço=" + endereço +
                '}';
    }
}
