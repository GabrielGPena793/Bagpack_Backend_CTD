package com.dh.aula32CrudExemplo.services;

import java.util.List;

public interface CrudService<T> {

    List<T> findAll();
    T findByID(Long id);
    void deleteById(Long id);
    T create(T t);
    T update(T t);
}
