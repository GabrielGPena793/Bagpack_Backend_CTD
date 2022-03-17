package com.ctd.model;

import java.io.Serializable;

public class Empregado implements Serializable {

    private String nome;
    private String sobrenome;
    private String documentoIndentificacao;
    private Double salario;

    public Empregado() {
    }

    public Empregado(String nome, String sobrenome, String documentoIndentificacao, Double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documentoIndentificacao = documentoIndentificacao;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumentoIndentificacao() {
        return documentoIndentificacao;
    }

    public void setDocumentoIndentificacao(String documentoIndentificacao) {
        this.documentoIndentificacao = documentoIndentificacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
//
//    @Override
//    public String toString() {
//        return "Empregado{" +
//                "nome='" + nome + '\'' +
//                ", sobrenome='" + sobrenome + '\'' +
//                ", documentoIndentificacao='" + documentoIndentificacao + '\'' +
//                ", salario=" + salario +
//                '}';
//    }


    @Override
    public String toString() {
        return  nome + ";" + sobrenome + ";" + documentoIndentificacao + ";" + String.format("%.2f",salario );
    }
}
