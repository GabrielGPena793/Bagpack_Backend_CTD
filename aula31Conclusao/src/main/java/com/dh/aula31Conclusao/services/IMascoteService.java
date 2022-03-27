package com.dh.aula31Conclusao.services;

import com.dh.aula31Conclusao.entitites.Mascote;

import java.util.List;

public interface IMascoteService<T> {

    void insert(T t);
    void delete(Long id);
    T findById(Long id);
    List<T> findAll();
    void update(T t);

}
