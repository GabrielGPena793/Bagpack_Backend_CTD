package com.springDh.aula21.services;

import com.springDh.aula21.model.Usuario;
import com.springDh.aula21.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public void excluir(Integer id){
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> buscar(Integer id){
        return usuarioRepository.findById(id);
    }

    public Usuario atualizar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
