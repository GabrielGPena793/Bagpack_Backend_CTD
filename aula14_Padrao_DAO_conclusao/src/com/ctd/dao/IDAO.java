package com.ctd.dao;

import java.util.List;

public interface IDAO<T> {

    void insert(T obj);
    void deleteById(Integer id);
    T findById(Integer id);
    List<T> findAll();
}
