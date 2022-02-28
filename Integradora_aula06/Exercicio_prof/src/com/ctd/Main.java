package com.ctd;

import com.ctd.model.entities.Filme;
import com.ctd.services.IGradeDeFilmes;
import com.ctd.services.impl.GradeDeFilmes;
import com.ctd.services.impl.GradeDeFilmesProxy;


public class Main {

    public static void main(String[] args) {

        IGradeDeFilmes gradeDeFilmes = new GradeDeFilmesProxy("149.203.02.60", new GradeDeFilmes());

        Filme filme = gradeDeFilmes.getFilme("Moana");

        System.out.println(filme);

    }
}
