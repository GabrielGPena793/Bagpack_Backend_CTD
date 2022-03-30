package com.springDh.aula21.services;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.dao.impl.ConsultasDaoMySql;
import com.springDh.aula21.model.Consultas;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {

    private IDao<Consultas> consultasIDao;

    public ConsultasService() {
        this.consultasIDao = new ConsultasDaoMySql();
    }

    public Consultas salvar(Consultas consultas){
        return consultasIDao.salvar(consultas);
    }
}
