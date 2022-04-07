package com.springDh.aula21.services;

import com.springDh.aula21.model.Dentista;
import com.springDh.aula21.repositories.DentistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    private DentistaRepository dentistaRepository;

    public Dentista salvar(Dentista dentista){
        return dentistaRepository.save(dentista);
    }

    public Optional<Dentista> buscar(int id){
        return dentistaRepository.findById(id);
    }

    public List<Dentista> buscarTodos(){
        return dentistaRepository.findAll();
    }

    public void excluir(Integer id){
        dentistaRepository.deleteById(id);
    }

    public Dentista atualizar(Dentista dentista){
        return dentistaRepository.save(dentista);
    }
}
