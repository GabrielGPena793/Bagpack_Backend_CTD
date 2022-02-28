package com.ctd.services.impl;

import com.ctd.model.entities.Filme;
import com.ctd.model.exceptions.FilmeNaoHabilitadoException;
import com.ctd.services.IGradeDeFilmes;

public class GradeDeFilmesProxy implements IGradeDeFilmes {

    private String ip;
    private GradeDeFilmes gradeDeFilmes;

    public GradeDeFilmesProxy(String ip, GradeDeFilmes gradeDeFilmes) {
        this.ip = ip;
        this.gradeDeFilmes = gradeDeFilmes;
    }

    @Override
    public Filme getFilme(String nome) {
        String[] primeiroNumero = ip.split("\\.");
        int numeroIp = Integer.parseInt(primeiroNumero[0]);

        Filme filme = gradeDeFilmes.getFilme(nome);

        if (numeroIp >= 0 && numeroIp <= 49){
            filme.setPais("Argentina");
            filme.setLinkProducao("www.filmesArgentina.com");
        }else  if (numeroIp <= 99){
            filme.setPais("Brasil");
            filme.setLinkProducao("www.filmesBrasil.com");
        }else if(numeroIp <= 149 ){
            filme.setPais("Colombia");
            filme.setLinkProducao("www.filmesColombia.com");
        }else {
            throw new FilmeNaoHabilitadoException("Filme não disponível no seu país");
        }

        return filme;
    }
}
