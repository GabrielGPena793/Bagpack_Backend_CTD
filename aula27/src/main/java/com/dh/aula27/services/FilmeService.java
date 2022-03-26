package com.dh.aula27.services;

import com.dh.aula27.dao.IDAO;
import com.dh.aula27.dao.impl.FilmeDAO;
import com.dh.aula27.entities.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {


    private final IDAO<Filme> filmeIDAO;

    public FilmeService() {
        this.filmeIDAO = new FilmeDAO();
    }

    public void insert(Filme filme){
        filmeIDAO.insert(filme);
    }

    public void delete(int id){
        filmeIDAO.delete(id);
    }

    public List<Filme> findAll(){
        return filmeIDAO.findAll();
    }
}
