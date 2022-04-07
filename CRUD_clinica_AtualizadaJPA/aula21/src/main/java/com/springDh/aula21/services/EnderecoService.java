package com.springDh.aula21.services;

import com.springDh.aula21.model.Endereco;
import com.springDh.aula21.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> buscar(int id){
        return enderecoRepository.findById(id);
    }

    public List<Endereco> buscarTodos(){
        return enderecoRepository.findAll();
    }

    public void excluir(Integer id){
        enderecoRepository.deleteById(id);
    }

    public Endereco atualizar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
}
