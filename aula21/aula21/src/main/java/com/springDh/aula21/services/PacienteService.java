package com.springDh.aula21.services;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.model.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente paciente){
        return pacienteIDao.salvar(paciente);
    }

    public Paciente buscarPorId(Integer id){
        return pacienteIDao.buscar(id).orElse(null);
    }

    public void excluir(Integer id){
        pacienteIDao.excluir(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }

    public Paciente atualizar (Paciente paciente){
        return pacienteIDao.atualizar(paciente);
    }
}
