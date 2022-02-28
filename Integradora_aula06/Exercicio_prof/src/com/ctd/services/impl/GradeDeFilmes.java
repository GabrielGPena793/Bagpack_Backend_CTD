package com.ctd.services.impl;

import com.ctd.model.entities.Filme;
import com.ctd.services.IGradeDeFilmes;

public class GradeDeFilmes implements IGradeDeFilmes {

    @Override
    public Filme getFilme(String nome) {
        Filme filme = new Filme();
        filme.setNome(nome);
        return filme;
    }

}
