package com.ctd.dao;

import java.util.List;

public interface IDAO<T> {

    void salvar(T t);
    T findById(int id);
    List<T> findAll();
    void deleteByID(int id);
    void update(T t);

}
