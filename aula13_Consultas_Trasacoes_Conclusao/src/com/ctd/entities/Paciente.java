package com.ctd.entities;

import java.util.Date;

public class Paciente {
    private String nome;
    private String sobreNome;
    private String endereco;
    private String rg;
    private Date dataCadastro;
    private String nomeUsuario;
    private String senha;

    public Paciente() {
    }

    public Paciente(String nome, String sobreNome, String endereco, String rg, Date dataCadastro, String nomeUsuario, String senha) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
