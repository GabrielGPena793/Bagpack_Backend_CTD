package com.ctd.services;

import com.ctd.dao.IDAO;
import com.ctd.model.Filial;

import java.util.List;

public class FilialService {

    private IDAO<Filial> filialIDAO;

    public FilialService(IDAO<Filial> filialIDAO) {
        this.filialIDAO = filialIDAO;
    }

    public Filial salvar(Filial filial){
        return filialIDAO.salvar(filial);
    }

    public List<Filial> findAll(){
        return filialIDAO.findAll();
    }
}
