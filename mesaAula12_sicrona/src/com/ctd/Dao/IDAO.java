package com.ctd.Dao;

import com.ctd.model.Funcionario;

import java.util.List;

public interface IDAO<T> {

    void insert(T t);
    void update(T t);
    Funcionario findById(int id);
    List<Funcionario> findAll();
    void delete(String campo, Object o);
}
