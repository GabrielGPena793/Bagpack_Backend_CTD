package com.springDh.aula21.services;

import com.springDh.aula21.dao.IDao;
import com.springDh.aula21.model.Endereco;

import java.util.List;
import java.util.Optional;

public class EnderecoService {

    private final IDao<Endereco> enderecoIDao;

    public EnderecoService(IDao<Endereco> enderecoIDaoIDao) {
        this.enderecoIDao = enderecoIDaoIDao;
    }

    public Endereco salvar(Endereco endereco){
        return enderecoIDao.salvar(endereco);
    }

    public Optional<Endereco> buscar(int id){
        return enderecoIDao.buscar(id);
    }

    public List<Endereco> buscarTodos(){
        return enderecoIDao.buscarTodos();
    }

    public void excluir(Integer id){
        enderecoIDao.excluir(id);
    }

    public void atualizar(Endereco endereco){
        enderecoIDao.atualizar(endereco);
    }
}
