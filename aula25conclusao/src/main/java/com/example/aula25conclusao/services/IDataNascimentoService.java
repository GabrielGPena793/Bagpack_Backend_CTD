package com.example.aula25conclusao.services;

import com.example.aula25conclusao.model.DataNascimento;

public interface IDataNascimentoService {

    Integer calcularIdade(Integer dia,Integer mes, Integer ano);
}
