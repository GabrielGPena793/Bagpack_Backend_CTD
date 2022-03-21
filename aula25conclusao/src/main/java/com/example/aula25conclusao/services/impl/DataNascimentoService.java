package com.example.aula25conclusao.services.impl;

import com.example.aula25conclusao.model.DataNascimento;
import com.example.aula25conclusao.services.IDataNascimentoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class DataNascimentoService  implements IDataNascimentoService {


    public Integer calcularIdade(Integer dia,Integer mes, Integer ano){
        DataNascimento dataNascimento = new DataNascimento(dia, mes, ano);
        LocalDate cliente = LocalDate.of(dataNascimento.getAno(),dataNascimento.getMes(), dataNascimento.getDia());
        LocalDate atual = LocalDate.now();

        Period period = Period.between(cliente, atual);

        return period.getYears();
    }
}
