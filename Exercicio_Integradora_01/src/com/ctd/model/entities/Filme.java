package com.ctd.model.entities;

public class Filme {

    private String nome, pais, linkProducao;

    public Filme() {
    }

    public Filme(String nome, String pais, String linkProducao) {
        this.nome = nome;
        this.pais = pais;
        this.linkProducao = linkProducao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLinkProducao() {
        return linkProducao;
    }

    public void setLinkProducao(String linkProducao) {
        this.linkProducao = linkProducao;
    }

    @Override
    public String toString() {
        return "Filme: " + nome +
                "\nPais: " + pais +
                "\nLink: " + linkProducao;
    }
}
