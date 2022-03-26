package com.dh.aula27.dao.impl;

import com.dh.aula27.dao.IDAO;
import com.dh.aula27.entities.Filme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FilmeDAO implements IDAO<Filme> {

    private final List<Filme> filmeList;

    public FilmeDAO() {
        this.filmeList = new ArrayList<>();
    }

    @Override
    public void insert(Filme filme) {
        filmeList.add(filme);
    }

    @Override
    public List<Filme> findAll() {
        return filmeList;
    }

    @Override
    public void delete(int id) {
        filmeList.removeIf(filme -> filme.getId() == id);
    }
}
