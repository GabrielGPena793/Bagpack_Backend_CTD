package com.ctd.model;

public class ClienteRoupa {

    private String tamanho;
    private String tipo;
    private boolean eNovo;
    private boolean eImportado;
    private boolean masCondicoes;

    public ClienteRoupa() {
    }

    public ClienteRoupa(String tamanho, String tipo, boolean eNovo, boolean eImportado, boolean masCondicoes) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.eNovo = eNovo;
        this.eImportado = eImportado;
        this.masCondicoes = masCondicoes;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean iseNovo() {
        return eNovo;
    }

    public void seteNovo(boolean eNovo) {
        this.eNovo = eNovo;
    }

    public boolean iseImportado() {
        return eImportado;
    }

    public void seteImportado(boolean eImportado) {
        this.eImportado = eImportado;
    }

    public boolean isMasCondicoes() {
        return masCondicoes;
    }

    public void setMasCondicoes(boolean masCondicoes) {
        this.masCondicoes = masCondicoes;
    }
}
