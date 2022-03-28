package com.springDh.aula21.services;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.model.Dentista;

import java.util.List;
import java.util.Optional;

public class DentistaService {

    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista salvar(Dentista dentista){
        return dentistaIDao.salvar(dentista);
    }

    public Optional<Dentista> buscar(int id){
        return dentistaIDao.buscar(id);
    }

    public List<Dentista> buscarTodos(){
        return dentistaIDao.buscarTodos();
    }

    public void excluir(Integer id){
        dentistaIDao.excluir(id);
    }

    public Dentista atualizar(Dentista dentista){
        return dentistaIDao.atualizar(dentista);
    }
}
