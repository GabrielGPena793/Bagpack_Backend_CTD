package com.ctd.model;

import java.io.Serializable;

public class PaginasFavoritas implements Serializable {

    private String url;
    private String nome;

    public PaginasFavoritas(String url, String nome) {
        this.url = url;
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PaginasFavoritas{" +
                "url='" + url + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
