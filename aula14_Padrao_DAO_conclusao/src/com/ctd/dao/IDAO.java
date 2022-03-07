package com.ctd.dao;

import java.util.List;

public interface IDAO<T> {

    void insert(T obj);
    void update(T obj);
    void deleteById(Integer id);
    T fingById(Integer id);
    List<T> findAll();
}
