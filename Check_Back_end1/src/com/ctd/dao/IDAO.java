package com.ctd.dao;

import com.ctd.model.Filial;

import java.util.List;

public interface IDAO <T>{

    T salvar(T t);
    List<T> findAll();
}
