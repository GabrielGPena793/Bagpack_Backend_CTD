package com.ctd.service;

import com.ctd.dao.IDAO;
import com.ctd.model.Endereco;

public class EnderecoService {

    private IDAO<Endereco> enderecoIDAO;

    public EnderecoService(IDAO<Endereco> enderecoIDAO) {
        this.enderecoIDAO = enderecoIDAO;
    }

    public Endereco salvar(Endereco endereco){
        enderecoIDAO.salvar(endereco);
        return endereco;
    }
}
