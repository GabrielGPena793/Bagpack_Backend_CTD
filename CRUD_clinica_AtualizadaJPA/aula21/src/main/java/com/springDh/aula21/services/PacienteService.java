package com.springDh.aula21.services;

import com.springDh.aula21.model.Paciente;
import com.springDh.aula21.model.Usuario;
import com.springDh.aula21.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public Paciente salvar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPorId(Integer id){
        return pacienteRepository.findById(id);
    }

    public void excluir(Integer id){
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteRepository.findAll();
    }

    public Paciente atualizar (Paciente paciente){
        return pacienteRepository.save(paciente);
    }
}
