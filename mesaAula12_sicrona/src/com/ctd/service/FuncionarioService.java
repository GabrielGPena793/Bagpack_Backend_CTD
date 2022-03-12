package com.ctd.service;

import com.ctd.Dao.IDAO;
import com.ctd.model.Funcionario;

import java.util.List;

public class FuncionarioService {

    private IDAO<Funcionario> funcionarioIDAO;

    public FuncionarioService(IDAO<Funcionario> funcionarioIDAO) {
        this.funcionarioIDAO = funcionarioIDAO;
    }

    public void insert(Funcionario funcionario){
        funcionarioIDAO.insert(funcionario);
    }

    public void update(Funcionario funcionario){
        funcionarioIDAO.update(funcionario);
    }

    public void delete(String campo, Object valor){
        funcionarioIDAO.delete(campo, valor);
    }

//    public void deleteByEmail(String email){
//        funcionarioIDAO.deleteByEmail(email);
//    }

    public Funcionario findById(int id){
        return funcionarioIDAO.findById(id);
    }

    public List<Funcionario> findAll(){
        return funcionarioIDAO.findAll();
    }
}
