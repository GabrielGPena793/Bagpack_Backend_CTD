package com.springDh.aula21.services;

import com.springDh.aula21.model.Consultas;
import com.springDh.aula21.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {

    private ConsultaRepository consultaRepository;

    public Consultas salvar(Consultas consultas){
        return consultaRepository.save(consultas);
    }
}
