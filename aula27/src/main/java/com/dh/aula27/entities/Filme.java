package com.dh.aula27.entities;

import java.util.Objects;


public class Filme {

    private Integer id;
    private String titulo;
    private String categoria;
    private Integer premios;

    public Filme() {
    }

    public Filme(Integer id, String titulo, String categoria, Integer premios) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.premios = premios;
    }

    public Filme(String titulo, String categoria, Integer premios) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.premios = premios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPremios() {
        return premios;
    }

    public void setPremios(Integer premios) {
        this.premios = premios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return id.equals(filme.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", premios=" + premios +
                '}';
    }
}
