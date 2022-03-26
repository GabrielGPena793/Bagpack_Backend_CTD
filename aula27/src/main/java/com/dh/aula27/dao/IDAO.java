package com.dh.aula27.dao;

import java.util.List;

public interface IDAO<T> {

    void insert(T t);
    List<T> findAll();
    void delete(int id);

}
